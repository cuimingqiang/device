package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Screen {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    private int densityDpi;

    private double scaledDensity;

    private double density;

    private int heightPixels;

    private double ydpi;

    private double xdpi;

    private int widthPixels;

    public void setDensityDpi(int densityDpi) {
        this.densityDpi = densityDpi;
    }

    public int getDensityDpi() {
        return this.densityDpi;
    }

    public void setScaledDensity(double scaledDensity) {
        this.scaledDensity = scaledDensity;
    }

    public double getScaledDensity() {
        return this.scaledDensity;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getDensity() {
        return this.density;
    }

    public void setHeightPixels(int heightPixels) {
        this.heightPixels = heightPixels;
    }

    public int getHeightPixels() {
        return this.heightPixels;
    }

    public void setYdpi(double ydpi) {
        this.ydpi = ydpi;
    }

    public double getYdpi() {
        return this.ydpi;
    }

    public void setXdpi(double xdpi) {
        this.xdpi = xdpi;
    }

    public double getXdpi() {
        return this.xdpi;
    }

    public void setWidthPixels(int widthPixels) {
        this.widthPixels = widthPixels;
    }

    public int getWidthPixels() {
        return this.widthPixels;
    }
}
