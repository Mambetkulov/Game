import java.util.Objects;

public class jonele_achyp_koidum_muha {
    private String jon ;
    private int age;
    private boolean a = true;
    private int bosh = 2;
    int aa=2;
    int aaa=2;
    int b=2;
    int bb=2;
    int ss=3;
    int s=2;
    int qq=2;
    int qd=2;
    int qdd=2;
    int v = 3;
    public jonele_achyp_koidum_muha() {
    }
    public jonele_achyp_koidum_muha(String jon, int age, boolean a) {
        this.jon = jon;
        this.age = age;
        this.a = a;
    }

    public void setJon(String jon) {
        this.jon = jon;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public String getJon() {
        return jon;
    }

    public int getAge() {
        return age;
    }

    public boolean isA() {
        return a;
    }

    public int getBosh(){
        return bosh;
    }

    public void setBosh(int bosh){
        this.bosh = bosh;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        jonele_achyp_koidum_muha that = (jonele_achyp_koidum_muha) o;
        return age == that.age && a == that.a && Objects.equals(jon, that.jon);
    }
    @Override
    public int hashCode() {
        return Objects.hash(jon, age, a);
    }
    @Override
    public String toString() {
        return "jonele_achyp_koidum_muha{" +
                "jon='" + jon + '\'' +
                ", age=" + age +
                ", a=" + a +
                '}';
    }
}
