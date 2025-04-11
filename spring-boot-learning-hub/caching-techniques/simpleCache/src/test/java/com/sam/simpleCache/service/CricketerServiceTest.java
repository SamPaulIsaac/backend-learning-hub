package com.sam.simpleCache.service;

import com.sam.simpleCache.entity.Cricketer;
import com.sam.simpleCache.repository.CricketerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.SimpleKey;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CricketerServiceTest {

    @MockBean
    private CricketerRepository cricketerRepository;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CricketerService cricketerService;


    @Test
    public void testGetCricketerByIdCaching() {
        // Arrange
        Cricketer cricketer = Cricketer.builder()
                .id(1L)
                .name("Sachin Tendulkar")
                .country("India")
                .runs(50000)
                .build();

        when(cricketerRepository.findById(cricketer.getId())).thenReturn(Optional.of(cricketer));

        // Act
        Cricketer cricketerFromDb = cricketerService.getCricketerById(cricketer.getId());  // Call 1: Fetches from DB and caches result
        Cricketer cricketerFromCache = cricketerService.getCricketerById(cricketer.getId());  // Call 2: Should return cached result

        // Assert
        assertEquals(cricketerFromDb, cricketerFromCache);

        // Verify that repository is called only once (for the first call)
        verify(cricketerRepository, times(1)).findById(cricketer.getId());


        // Ensure the cache contains the cricketer
        Cache cache = cacheManager.getCache("cricketers");
        assertNotNull(cache);
        Cricketer cachedCricketer = cache.get(cricketer.getId(), Cricketer.class);
        assertNotNull(cachedCricketer);
        assertEquals(cricketer.getId(), cachedCricketer.getId());
        assertEquals(cricketer.getName(), cachedCricketer.getName());
        assertEquals(cricketer.getCountry(), cachedCricketer.getCountry());
        assertEquals(cricketer.getRuns(), cachedCricketer.getRuns());
    }

    @Test
    public void testGetCricketersCaching() {
        // Arrange
        Cricketer cricketer1 = Cricketer.builder()
                .id(2L)
                .name("Sachin Tendulkar")
                .country("India")
                .runs(50000)
                .build();

        Cricketer cricketer2 = Cricketer.builder()
                .id(3L)
                .name("Sachin Tendulkar")
                .country("India")
                .runs(50000)
                .build();

        when(cricketerRepository.findAll()).thenReturn(Arrays.asList(cricketer1, cricketer2));

        // Act
        List<Cricketer> cricketerFromDb = cricketerService.getAllCricketers();  // Call 1: Fetches from DB and caches result
        List<Cricketer> cricketerFromCache = cricketerService.getAllCricketers();  // Call 2: Should return cached result

        // Assert
        assertEquals(cricketerFromDb, cricketerFromCache);

        // Verify that repository is called only once (for the first call)
        verify(cricketerRepository, times(1)).findAll();


        // Ensure the cache contains the cricketer
        Cache cache = cacheManager.getCache("cricketers");
        assertNotNull(cache, "Cache should not be null");

        Cache.ValueWrapper valueWrapper = cache.get(new SimpleKey()); // Adjust SimpleKey as needed
        assertNotNull(valueWrapper, "ValueWrapper should not be null");

        Object cachedValue = valueWrapper.get();
        assertTrue(cachedValue instanceof List, "Cached value should be a List");
        List<Cricketer> cachedCricketers = (List<Cricketer>) cachedValue;
        assertEquals(2, cachedCricketers.size(), "Cache should contain exactly 2 cricketers");

        // Verify the cached cricketers
        Cricketer cachedCricketer1 = cachedCricketers.get(0);
        Cricketer cachedCricketer2 = cachedCricketers.get(1);

        assertNotNull(cachedCricketer1, "Cached cricketer 1 should not be null");
        assertNotNull(cachedCricketer2, "Cached cricketer 2 should not be null");
        assertCricketersEqual(cricketer1, cachedCricketer1);
        assertCricketersEqual(cricketer2, cachedCricketer2);
    }

    @Test
    public void testSaveCricketerCaching() {
        // Arrange
        Cricketer cricketer = Cricketer.builder()
                .id(4L)
                .name("Sachin Tendulkar")
                .country("India")
                .runs(50000)
                .build();

        when(cricketerRepository.save(cricketer)).thenReturn(cricketer);

        // Act
        Cricketer savedCricketer = cricketerService.saveCricketer(cricketer);

        // Assert
        assertNotNull(savedCricketer);
        assertEquals(cricketer.getId(), savedCricketer.getId());

        // Verify that the repository save method was called once
        verify(cricketerRepository, times(1)).save(cricketer);

        // Ensure the cache contains the cricketer
        Cache cache = cacheManager.getCache("cricketers");
        assertNotNull(cache);
        Cache.ValueWrapper valueWrapper = cache.get(cricketer.getId());
        assertNotNull(valueWrapper);
        Cricketer cachedCricketer = (Cricketer) valueWrapper.get();
        assertEquals(cricketer, cachedCricketer);
    }

    @Test
    public void testUpdateCricketerCaching() {
        // Arrange
        Cricketer cricketer = Cricketer.builder()
                .id(4L)
                .name("Sachin Tendulkar")
                .country("India")
                .runs(50000)
                .build();

        Cricketer updatedCricketer = Cricketer.builder()
                .id(4L)
                .name("Sachin Tendulkar")
                .country("India")
                .runs(55000)  // Updated runs
                .build();

        when(cricketerRepository.save(updatedCricketer)).thenReturn(updatedCricketer);

        // Act
        Cricketer savedCricketer = cricketerService.saveCricketer(updatedCricketer); // Save and cache

        // Assert
        assertNotNull(savedCricketer);
        assertEquals(updatedCricketer.getId(), savedCricketer.getId());
        assertEquals(updatedCricketer.getRuns(), savedCricketer.getRuns());

        // Verify that the repository save method was called once
        verify(cricketerRepository, times(1)).save(updatedCricketer);

        // Ensure the cache contains the updated cricketer
        Cache cache = cacheManager.getCache("cricketers");
        assertNotNull(cache);
        Cache.ValueWrapper valueWrapper = cache.get(updatedCricketer.getId());
        assertNotNull(valueWrapper);
        Cricketer cachedCricketer = (Cricketer) valueWrapper.get();
        assertEquals(updatedCricketer, cachedCricketer);
    }


    @Test
    public void testDeleteCricketerCaching() {
        // Arrange
        Long cricketerId = 1L;

        // Act
        cricketerService.deleteCricketer(cricketerId); // Delete and evict cache

        // Assert
        // Verify that the repository delete method was called once
        verify(cricketerRepository, times(1)).deleteById(cricketerId);

        // Ensure the cache no longer contains the cricketer
        Cache cache = cacheManager.getCache("cricketers");
        assertNotNull(cache);
        Cache.ValueWrapper valueWrapper = cache.get(cricketerId);
        assertNull(valueWrapper, "Cache should not contain deleted cricketer");
    }

    private void assertCricketersEqual(Cricketer expected, Cricketer actual) {
        assertEquals(expected.getId(), actual.getId(), "IDs should match");
        assertEquals(expected.getName(), actual.getName(), "Names should match");
        assertEquals(expected.getCountry(), actual.getCountry(), "Countries should match");
        assertEquals(expected.getRuns(), actual.getRuns(), "Runs should match");
    }
}
