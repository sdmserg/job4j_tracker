package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showError() {
        System.out.println("Error active: " + active);
        System.out.println("Error status code: " + status);
        System.out.println("Error message: " + message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        Error okError = new Error(false, 200, "OK");
        Error notFoundError = new Error(true, 404, "Not Found");
        Error gatewayError = new Error(true, 504, "Gateway Timeout");
        defaultError.showError();
        okError.showError();
        notFoundError.showError();
        gatewayError.showError();
    }
}
