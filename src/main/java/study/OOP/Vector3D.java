package study.OOP;

public class Vector3D {

    private final double x;
    private final double y;
    private final double z;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getLength(){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
    }

    public double getScalarMultipl(Vector3D vector3D){
        return this.x*vector3D.getX()+this.y*vector3D.getY()+this.getZ()*vector3D.getZ();
    }

    public Vector3D getVectorMultipl(Vector3D vector3D){
        return new Vector3D(
                this.y*vector3D.getZ()-this.z*vector3D.getY(),
                this.z*vector3D.getX()-this.x*vector3D.getZ(),
                this.x*vector3D.getY()-this.y*vector3D.getX()
                );
    }

    public double getAngle(Vector3D vector3D){
        return getScalarMultipl(vector3D)/(getLength()*vector3D.getLength());
    }

    public Vector3D getVectorSum(Vector3D vector3D){
        return new Vector3D(
                this.x+vector3D.getX(),
                this.y+vector3D.getY(),
                this.z+vector3D.getZ()

        );
    }

    public Vector3D getVectorSub(Vector3D vector3D){
        return new Vector3D(
                this.x-vector3D.getX(),
                this.y-vector3D.getY(),
                this.z-vector3D.getZ()

        );
    }

    public static Vector3D[] generate(int n){
        Vector3D[] vector3DS = new Vector3D[n];
        for (int i = 0; i < vector3DS.length; i++) {
            vector3DS[i] = new Vector3D(Math.random(),Math.random(),Math.random());
        }
        return vector3DS;
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
