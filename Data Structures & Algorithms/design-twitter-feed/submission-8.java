class Tweet {
    static int currTime = 0;
    int tweetId;
    int userId;
    int time;

    public Tweet(int tweetId, int userId) {
        this.tweetId = tweetId;
        this.userId = userId;
        this.time = currTime++;
    }
}

class Twitter {
    Queue<Tweet> pq;
    Map<Integer, HashSet<Integer>> hm;

    public Twitter() {
        pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        hm = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        pq.add(new Tweet(tweetId, userId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> polledTweets = new ArrayList<>();
        List<Integer> newsFeedIds = new ArrayList<>();

        int count = 0;
        HashSet<Integer> followees = hm.getOrDefault(userId, new HashSet<Integer>());
        while(count < 10 && !pq.isEmpty()){
            Tweet item = pq.poll();
            polledTweets.add(item);

            if(item.userId == userId || followees.contains(item.userId)){
                newsFeedIds.add(item.tweetId);
                count++;
            }
        }

        for(Tweet tweet: polledTweets) pq.add(tweet);

        return newsFeedIds;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followees = hm.getOrDefault(followerId, new HashSet<Integer>());
        followees.add(followeeId);
        hm.put(followerId, followees);
    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followees = hm.getOrDefault(followerId, new HashSet<Integer>());
        if(followees.contains(followeeId)){
            followees.remove(followeeId);
        }
        hm.put(followerId, followees);
    }
}
