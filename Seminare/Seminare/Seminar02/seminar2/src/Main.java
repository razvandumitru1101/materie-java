public class Main{
    static void main(String[] args) {
        Books books;
        Books books1=new Books("Harry Potter",500,"jk Rowlinss");
        Books books2=books1;
        System.out.println(books2.getName());
        books2.setName("gigel");
        System.out.println(books2.getName())  ;
    }
}