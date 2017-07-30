package com.aakash.practice.booking.test;

import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/23/17.
 */
public class HotelReviews {


    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String reviewLine = a.nextLine();
        Set<String> reviewSet = new HashSet<String>();
        for(String reviewWord : Arrays.asList(reviewLine.split(" "))){
            reviewSet.add(reviewWord.toLowerCase());
        }
        int n = a.nextInt();

        Map<Integer, HotelReview> hotelReviews = new HashMap();

        for(int i=1;i<=n;i++){
            int id = a.nextInt();
            a.nextLine();
            String review = a.nextLine();
            int reviewCount = countReviews(review, reviewSet);
            if(hotelReviews.containsKey(id)){
                HotelReview hotelReview = hotelReviews.get(id);
                hotelReview.updateReview(reviewCount);
            } else {
                HotelReview hotelReview = new HotelReview(id, reviewCount);
                hotelReviews.put(id, hotelReview);
            }
        }

        List<HotelReview> hotels = new ArrayList<>(hotelReviews.values());
        Collections.sort(hotels, (o1, o2) -> {
            if (o1.reviewCount == o2.reviewCount) {
                return o1.id - o2.id;
            }
            return o2.reviewCount - o1.reviewCount;
        });
        for(HotelReview hr : hotels){
            System.out.print(hr.id+" ");
        }

    }

    private static int countReviews(String review, Set<String> reviewSet){
        int count = 0;
        for(String word : review.split(" ")){
            word = word.replaceAll("\\.","");
            word = word.replaceAll(",","");
            word = word.toLowerCase();
            if(reviewSet.contains(word)){
                count++;
            }
        }
        return count;
    }

    static class HotelReview {
        int id;
        int reviewCount;

        public HotelReview(int id, int reviewCount){
            this.id = id;
            this.reviewCount = reviewCount;
        }

        public void updateReview(int count){
            this.reviewCount += count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HotelReview that = (HotelReview) o;

            return id == that.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}


