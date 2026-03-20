package com.starlink.backend.lld.adapter;

public class RazorPayAdapter  implements PaymentService{
    RazorpayAPI razorpayAPI;

    public RazorPayAdapter(RazorpayAPI razorpayAPI) {
        this.razorpayAPI = razorpayAPI;
    }

    @Override
    public void payment(double amount) {
        razorpayAPI.makePayment(amount);
    }
}
