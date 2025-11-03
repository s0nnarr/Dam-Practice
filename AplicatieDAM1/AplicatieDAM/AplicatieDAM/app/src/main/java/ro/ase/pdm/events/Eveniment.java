package ro.ase.pdm.events;

import java.time.LocalTime;

public class Eveniment {
    private int _id;
    private String categorie;
    private String data;
    private String ora;
    private String locatia;
    private String descriere;

    public void setData(String data) {
        this.data = data;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Eveniment(int _id, String categorie, String data, String ora, String locatia, String descriere) {
        this._id = _id;
        this.categorie = categorie;
        this.data = data;
        this.locatia = locatia;
        this.descriere = descriere;
    }

    public Eveniment() {}

    @Override
    public String toString() {
        return "Eveniment{" +
                "_id=" + _id +
                ", categorie='" + categorie + '\'' +
                ", data=" + data +
                ", locatia='" + locatia + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getLocatia() {
        return locatia;
    }

    public void setLocatia(String locatia) {
        this.locatia = locatia;
    }

}