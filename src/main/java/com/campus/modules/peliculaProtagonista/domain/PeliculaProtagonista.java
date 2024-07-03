package com.campus.modules.peliculaProtagonista.domain;

public class PeliculaProtagonista {
    private int idPelicula;
    private int idProtagonista;
    private int idTipoActor;

    public PeliculaProtagonista(int idPelicula, int idProtagonista, int idTipoActor) {
        this.idPelicula = idPelicula;
        this.idProtagonista = idProtagonista;
        this.idTipoActor = idTipoActor;
    }

    public PeliculaProtagonista() {
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdProtagonista() {
        return idProtagonista;
    }

    public void setIdProtagonista(int idProtagonista) {
        this.idProtagonista = idProtagonista;
    }

    public int getIdTipoActor() {
        return idTipoActor;
    }

    public void setIdTipoActor(int idTipoActor) {
        this.idTipoActor = idTipoActor;
    }

    @Override
    public String toString() {
        return "PeliculaProtagonista [idPelicula=" + idPelicula + ", idProtagonista=" + idProtagonista
                + ", idTipoActor=" + idTipoActor + "]";
    }
}
