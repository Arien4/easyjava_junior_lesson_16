package com.roilen.code.easyjava;

public class Message {
    private String message;
    private boolean sent;

    public Message(String message, boolean sent) {
        this.message = message;
        this.sent = sent;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSent() {
        return sent;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public synchronized void say(String message) {
        while (isSent()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setMessage(message);
        this.setSent(true);
        System.out.println("Message sent: " + this.getMessage());
        notify();
    }

    public synchronized void reply() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            while(!isSent()) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Received: " + this.message);
        this.setSent(false);
        notify();
    }
}
