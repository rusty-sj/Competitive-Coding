class WebTime {
    String website;
    int timeStamp;
        
    public WebTime(String website, int timeStamp) {
        this.website = website;
        this.timeStamp = timeStamp;
    }
}

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<WebTime>> map = new HashMap<>();
        int n = username.length;
        
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(username[i], new ArrayList<WebTime>());
            map.get(username[i]).add(new WebTime(website[i], timestamp[i]));
        }
        
        String sequence = "";
        Map<String, Integer> seqCounts = new HashMap<>();
        for (Map.Entry<String, List<WebTime>> entry : map.entrySet()) {
            String user = entry.getKey();
            List<WebTime> userList = entry.getValue();
            Collections.sort(userList, (wt1, wt2) -> (wt1.timeStamp - wt2.timeStamp));
            
            Set<String> set = new HashSet<>();
            
            for (int i = 0; i < userList.size(); i++) {
                for (int j = i + 1; j < userList.size(); j++) {
                    for (int k = j + 1; k < userList.size(); k++) {
                        String seq = userList.get(i).website + " " + userList.get(j).website + " " + userList.get(k).website;
                        if (!set.contains(seq)) {
                            seqCounts.put(seq, seqCounts.getOrDefault(seq, 0) + 1);
                            set.add(seq);
                        }
                        
                        if (sequence.equals("") || seqCounts.get(sequence) < seqCounts.get(seq) || (seqCounts.get(sequence) == seqCounts.get(seq) && sequence.compareTo(seq) > 0)) {
                            // make sure the right lexi order
                            sequence = seq;
                        }
                    }
                }
            }
        }
        
        return Arrays.asList(sequence.split("\\s"));
    }
}