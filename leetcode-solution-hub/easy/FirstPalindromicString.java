public class FirstPalindromicString {
    public static void main(String[] args) {
        String[] words = {"cuwyewejbweauuqzgrwelfufepggovynpfpsililvyyriptslqeozt", "htgxpnczbpvlusjurjsqychmqodhscocwjuauknpnmihfqpbauc", "dubdyahhthfqkkzobvyqubatmokivkohbf", "xublhlpqooqpbbabfpyrcjxnvnlscrdtelqkghcqtaupnfaqqamicuenzzrd", "vistwooewmoivfxehbhixbugsbqaldatpctwzcnjowiyrdkrxzewcynlspn", "besqzdtphbykjwhaelhfvdbsdgseitjsiyhsscurszexanddkmrdiemjlvkquojzfxduvuvwdmtdekq", "ttmdwnflxtpwjkccibovkfvwwwvploplpfudaodjirmdpjmytvrfovpzohknenbvlkdhrdadjqybbsmmr", "jdccsoyymancunxzkrhpchuank", "suczpwnybruihzohmolcduuktqrhspgqgrffdqxvizqhcapgnhyknrhts", "evwrfzhlabzfqujheneyyzudluqzdekgwozukbi", "ngjbpmaltqjgktyr", "kyawpemvdakqqgfvrhlnhzgzogkiyiimzaqrbxiebnvyoyjmizejfxnrhsjucnaixejhlyhtvvlw", "gmtunieovmbwfipdolnhqzbkhaacpjzkqayxxrhsxlpbcaqvavxqc", "cytlcpexaloxmzulopjxojctinfmwfsbnogvsdjdjmvetxemxpifognve", "nrgngrctstjsagffjshnepkgulybshqtacisttuorgjmseygqxxggrsq", "zqpobtizdmfiskagcx", "junpemjgbgidnitkm", "lynizstfnfoeafchehuimvrzzzkvjsfmbrlndzxkqzimzirrcbbpulpdylvcaiudtvovwybdpdfdrhnwmtpkevtnzwpgxvfz", "hrlvuzoetkryv", "urlsclyflbctotefixfgxukgykawydcmnyfvwkrnfmgpnzjprucpwvkbetjqxtlqyvmhrkdobwhokqihelus", "zcomqjooyuxnmfztfdhbruywfwcpwhmvjugemdsasujylsyitdkhcmxqonylzvvsumqoqzunuinzvrvgylm", "cvsawgmtjhvhqrvzpzvrqhvhjtmgwasvc", "bpirpdammxjradwidbfssgboqfcnhfhcgo", "zarjrbciinrdsytxnsongwhxuljuddqubffmrgmsetzsucnyfjqxijwnfohokrseufiztwxhx", "wzhsvfavugehtyyrfzmgcitugbfnhpwlzgtukglyvowvagookijbsxonszorpapdsvvjduycbusbmqoqia", "shrdcnbrdyniwaaauxzts", "qszoviptlppy", "oyahaoidfqjpcijiybxniljngsyyonywlaymfxbywdaouxfxgqhmyhcsxywucwfxrkgrlrjkrefe", "boljfwlfzbeqzlsqijgqdqhrkjjzlxvqygnqzhapadfuxlswsdzxnqxxrrvrghdglefx", "eexbfkvfkpdrgtkssiagbkkccvmhyitrkemaepqje", "zlaczhdsfuyvpqigmjtieqcmcxyfcivlmflyfjocqibabxqmntfcxpirygfh"};
        for (String word : words) {
            if (isPalindrome(word)) {
                System.out.println("First Palindrome: " + word);
                break;
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            else {
                l++;
                r--;
            }
        }
        return true;

    }
}
