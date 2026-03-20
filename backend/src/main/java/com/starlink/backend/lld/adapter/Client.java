package com.starlink.backend.lld.adapter;

public class Client {
    public static void main(String[] args) {
        RazorpayAPI razorpayAPI= new RazorpayAPI();
        PaymentService razorPayAdapter= new RazorPayAdapter(razorpayAPI);
        razorPayAdapter.payment(123.09);
    }
}
