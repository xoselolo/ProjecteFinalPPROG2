package com.example.xosel.projectefinalpprog2.model;

public class SchoolType {
    //Attributes
    private boolean isInfantil;
    private boolean isPrimaria;
    private boolean isEso;
    private boolean isBatxillerat;
    private boolean isFp;
    private boolean isUniversitat;

    //Constructor
    public SchoolType(boolean isInfantil, boolean isPrimaria, boolean isEso, boolean isBatxillerat, boolean isFp, boolean isUniversitat) {
        this.isInfantil = isInfantil;
        this.isPrimaria = isPrimaria;
        this.isEso = isEso;
        this.isBatxillerat = isBatxillerat;
        this.isFp = isFp;
        this.isUniversitat = isUniversitat;
    }

    //Getters & Setters
    public boolean isInfantil() {
        return isInfantil;
    }

    public void setInfantil(boolean infantil) {
        isInfantil = infantil;
    }

    public boolean isPrimaria() {
        return isPrimaria;
    }

    public void setPrimaria(boolean primaria) {
        isPrimaria = primaria;
    }

    public boolean isEso() {
        return isEso;
    }

    public void setEso(boolean eso) {
        isEso = eso;
    }

    public boolean isBatxillerat() {
        return isBatxillerat;
    }

    public void setBatxillerat(boolean batxillerat) {
        isBatxillerat = batxillerat;
    }

    public boolean isFp() {
        return isFp;
    }

    public void setFp(boolean fp) {
        isFp = fp;
    }

    public boolean isUniversitat() {
        return isUniversitat;
    }

    public void setUniversitat(boolean universitat) {
        isUniversitat = universitat;
    }
}
