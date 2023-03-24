class Circle {

    double radius;

    public double getLength(){
        return 2 * this.radius * Math.PI;
    }

    public double getArea(){
        return Math.pow(this.radius,2) * Math.PI;
    }
}