public class Codec {

    Map<String, String> urlToCode, codeToUrl;
    String baseUrl = "http://tinyurl.com/";
    
    public Codec() {
        this.urlToCode = new HashMap<>();
        this.codeToUrl = new HashMap<>();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hash = longUrl.hashCode() + "";
        if (!urlToCode.containsKey(longUrl)) {
            urlToCode.put(longUrl, hash);
            codeToUrl.put(hash, longUrl);
        }
        return baseUrl + urlToCode.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeToUrl.get(shortUrl.substring(baseUrl.length()));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));