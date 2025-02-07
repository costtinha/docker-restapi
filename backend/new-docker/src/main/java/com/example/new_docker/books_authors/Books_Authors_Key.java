package com.example.new_docker.books_authors;

import java.io.Serializable;
import java.util.Objects;

public class Books_Authors_Key implements Serializable {
    private int books_id;
    private int authors_id;

    public Books_Authors_Key(int books_id, int authors_id) {
        this.books_id = books_id;
        this.authors_id = authors_id;
    }

    public Books_Authors_Key() {
    }

    public int getBooks_id() {
        return books_id;
    }

    public void setBooks_id(int books_id) {
        this.books_id = books_id;
    }

    public int getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(int authors_id) {
        this.authors_id = authors_id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        Books_Authors_Key obj = (Books_Authors_Key) o;
        return Objects.equals(this.books_id, obj.books_id) &&
                Objects.equals(this.authors_id, obj.authors_id);
    }


    @Override
    public int hashCode(){ return Objects.hash(books_id,authors_id);}
}
