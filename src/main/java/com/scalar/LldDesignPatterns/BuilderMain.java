package com.scalar.LldDesignPatterns;


class Sandwich{
    private  String bread;
    private  String lettuce;
    private  String cheese;
    private  String tomato;

    private Sandwich(){};

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private String bread;
        private String lettuce;
        private String cheese;
        private String tomato;

        public String getBread() {
            return bread;
        }

        public Builder setBread(String bread) {
            this.bread = bread;
            return this;
        }

        public String getLettuce() {
            return lettuce;
        }

        public Builder setLettuce(String lettuce) {
            this.lettuce = lettuce;
            return this;
        }

        public String getCheese() {
            return cheese;
        }

        public Builder setCheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public String getTomato() {
            return tomato;
        }

        public Builder setTomato(String tomato) {
            this.tomato = tomato;
            return this;
        }

        public Sandwich build(){
            Sandwich sandwich = new Sandwich();
            sandwich.bread = bread;
            sandwich.lettuce = lettuce;
            sandwich.cheese = cheese;
            sandwich.tomato = tomato;
            return sandwich;
        }
    }

    @Override
    public String toString()
    {
        return "the Sandwich is prepared with "+this.bread+" "+this.lettuce+" "+this.cheese+" "+this.tomato;
    }
}
public class BuilderMain {

    public static void main(String[] args) {

        Sandwich sd=Sandwich.getBuilder()
                .setBread("Parle")
                .setLettuce("Green")
                .setCheese("Amul")
                .setTomato("Organic")
                .build();

        System.out.println(sd);
    }
}
