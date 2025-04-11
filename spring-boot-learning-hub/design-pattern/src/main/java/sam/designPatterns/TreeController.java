package sam.designPatterns;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/trees")
public class TreeController {

    @GetMapping("/plastic")
    public String createPlasticTree() {
        Tree plasticTree = new PlasticTree();
        return "Created: " + plasticTree.getType();
    }

    @GetMapping("/pine")
    public String createPineTree() {
        Tree pineTree = new PineTree();
        return "Created: " + pineTree.getType();
    }
}
