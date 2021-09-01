package Ford;

public class FordBase {
    public static void main(String[] args) {
        Ford manager = new Ford();
        manager.salary(30000, 2500);
        Ford engineer = new Ford();
        engineer.salary(20000);
        Ford auditor = new Ford();
        auditor.salary(35000, 3000, 2500);
        Ford supervisor = new Ford();
        supervisor.salary();

    }
}

class Ford {
    String title;
    float salary = 0, da = 0, hra = 0, car = 0, travelling = 0, lta = 0, basic = 0, mobile = 0;

    public void salary(float basic, float car) {
        this.title = "Manager";
        this.basic = basic;
        this.da = basic;
        this.hra = (float) (0.5 * basic);
        this.car = car;
        this.travelling = (float) (0.15 * basic);
        this.calculateSalary();
        System.out.println(this.title + ": " + this.salary);
    }

    public void salary(float basic) {
        this.title = "Engineer";
        this.basic = basic;
        this.da = basic;
        this.hra = (float) (0.3 * basic);
        this.travelling = (float) (0.05 * basic);
        this.calculateSalary();
        System.out.println(this.title + ": " + this.salary);
    }

    public void salary(float basic, float mobile, float car) {
        this.title = "Auditor";
        this.basic = basic;
        this.da = basic;
        this.hra = (float) (0.3 * basic);
        this.lta = (float) (0.1 * basic);
        this.travelling = (float) (0.05 * basic);
        this.mobile = mobile;
        this.car = car;
        this.calculateSalary();
        System.out.println(this.title + ": " + this.salary);
    }

    public void salary() {
        this.title = "Supervisor";
        this.basic = 10000;
        this.da = this.basic;
        this.hra = (float) (0.25 * basic);
        this.calculateSalary();
        System.out.println(this.title + ": " + this.salary);

    }

    public void calculateSalary() {
        this.salary = this.basic + this.da + this.hra + this.car + this.travelling + this.lta + this.mobile;
    }
}