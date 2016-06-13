package org.eclairjs.nashorn.wrap.mllib.recommendation;

import org.eclairjs.nashorn.wrap.WrappedClass;
import org.eclairjs.nashorn.wrap.WrappedFunction;


public class Rating extends WrappedClass {

    org.apache.spark.mllib.recommendation.Rating rating;

    public Rating(org.apache.spark.mllib.recommendation.Rating rating) {
        this.rating=rating;
    }

    public Rating(int user, int product, double rating)  {
        this.rating=new org.apache.spark.mllib.recommendation.Rating(user,product,rating);
    }

    public Object getJavaObject() {return rating;}

    public String getClassName() {return "Rating";}
    public  boolean checkInstance(Object other){ return other instanceof Rating;}


    WrappedFunction  F_user = new WrappedFunction () {
        @Override
        public Object call(Object thiz, Object... args) {
            return rating.user();
        }
    };

    WrappedFunction F_product  = new  WrappedFunction () {
        @Override
        public Object call(Object thiz, Object... args) {
            return rating.product();
        }
    };

    WrappedFunction F_rating  = new  WrappedFunction (){
        @Override
        public Object call(Object thiz, Object... args) {
            return rating.rating();
        }
    };

    // get the value of that named property
    @Override
    public Object getMember(String name) {
        switch (name) {
            case "user": return F_user;
            case "product": return F_product;
            case "rating": return F_rating;
        }
        return super.getMember(name);
    }
    @Override
    public boolean hasMember(String name) {
        switch (name) {
            case "user":
            case "product":
            case "rating":
                return true;
        }
        return super.hasMember(name);
    }

}
