package com.example.ignore.booking;

import java.util.*;
class Solution {

    public static class HotelReview implements Comparable<HotelReview>{
        int hotelId;
        int score;

        public HotelReview(int hotelId, int score) {
            this.hotelId = hotelId;
            this.score = score;
        }

        @Override
        public int compareTo(HotelReview that) {
            int compareByScoreReversed = Integer.compare(that.score, this.score);
            if (compareByScoreReversed == 0) {
                return Integer.compare(this.hotelId, that.hotelId);
            } else {
                return compareByScoreReversed;
            }
        }
    }

    public static List<Integer> awardTopKHotels
            (String positiveKeywords,
             String negativeKeywords,
             List<Integer> hotelIds,
             List<String> reviews,
             int k) {
        String[] pk = positiveKeywords.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        Map<String, Integer> positiveReviews = createFrequencyMap(pk);

        String[] nk = negativeKeywords.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        Map<String, Integer> negativeReviews = createFrequencyMap(nk);

        Map<Integer, Integer> hotelReviews = new HashMap<>();
        for (int i = 0; i < hotelIds.size(); i++) {
            int score = 0;
            String[] review = reviews.get(i).replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            for (String word: review) {
                String lowerCased = word.toLowerCase();
                score += positiveReviews.getOrDefault(lowerCased, 0) * 3;
                score -= negativeReviews.getOrDefault(lowerCased, 0);
            }
            int oldScore = hotelReviews.getOrDefault(hotelIds.get(i), 0);
            hotelReviews.put(hotelIds.get(i), oldScore + score);
        }

        PriorityQueue pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : hotelReviews.entrySet()) {
            pq.add(new HotelReview(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            HotelReview hr = (HotelReview) pq.poll();
            result.add(hr.hotelId);
        }

        return result;
    }

    private static Map<String, Integer> createFrequencyMap(String[] pk) {
        Map<String, Integer> reviews = new HashMap<>();

        for (String keyword: pk) {
            int count = reviews.getOrDefault(keyword, 0);
            reviews.put(keyword, count + 1);
        }

        return reviews;
    }
}
