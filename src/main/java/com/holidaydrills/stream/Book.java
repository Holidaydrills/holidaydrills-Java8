package com.holidaydrills.stream;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Book)) {
            return false;
        }
        Book other = (Book) o;
        if(other.getTitle().equals(this.getTitle())) {
            return true;
        }
        return false;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
