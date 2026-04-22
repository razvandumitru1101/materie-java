public class Books {

    private String name;
   private int nrPag;
    private String autor;

    public Books() {};

    public Books(String name,int nrPag,String autor)
    {
        this.name=name;
        this.nrPag=nrPag;
        this.autor=autor;

    }
    public Books(Books b)
    {
        this.name=b.name;
        this.autor=b.autor;
        this.nrPag=b.nrPag;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrPag() {
        return nrPag;
    }

    public void setNrPag(int nrPag) {
        this.nrPag = nrPag;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    // orice clasa mosteneste object(extends object)
}
