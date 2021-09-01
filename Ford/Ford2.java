package Ford;

// Method overriding
public class Ford2 {
    public static void main(String[] args) {
        Manager m1 = new Manager(30000);
        m1.salary();

        Engineer e1 = new Engineer(20000);
        e1.salary();

        Auditor a1 = new Auditor(35000, 3000, 2500);
        a1.salary();

        Supervisor s1 = new Supervisor(10000);
        s1.salary();
    }
}

class Employee {
    float basic = 0, da = 0, hra = 0;

    public void salary() {
        ;
    }
}

class Manager extends Employee {
    String title = "Manager";
    float salary = 0, car = 0, travelling = 0;

    Manager(float basic) {
        this.basic = basic;
        this.da = this.basic;
        this.hra = (float) (0.5 * this.basic);
        this.car = 2500;
        this.travelling = (float) (0.15 * this.basic);
    }

    public void salary() {
        this.salary = this.basic + this.da + this.hra + this.car + this.travelling;
        System.out.println(this.title + ": " + this.salary);
    }
}

class Engineer extends Employee {
    String title = "Engineer";
    float salary = 0, car = 0, travelling = 0;

    Engineer(float basic) {
        this.basic = basic;
        this.da = basic;
        this.hra = (float) (0.3 * basic);
        this.travelling = (float) (0.05 * basic);

    }

    public void salary() {
        this.salary = this.basic + this.da + this.hra + this.car + this.travelling;
        System.out.println(this.title + ": " + this.salary);
    }
}

class Auditor extends Employee {
    String title = "Auditor";
    float salary = 0, travelling = 0, lta = 0, mobile = 0, car = 0;

    Auditor(float basic, float mobile, float car) {
        this.basic = basic;
        this.da = basic;
        this.hra = (float) (0.3 * basic);
        this.lta = (float) (0.1 * basic);
        this.travelling = (float) (0.05 * basic);
        this.mobile = mobile;
        this.car = car;

    }

    public void salary() {
        this.salary = this.basic + this.da + this.hra + this.car + this.travelling + this.lta + this.mobile;
        System.out.println(this.title + ": " + this.salary);
    }
}

class Supervisor extends Employee {
    String title = "Supervisor";
    float salary = 0;

    Supervisor(float basic) {
        this.basic = basic;
        this.da = basic;
        this.hra = (float) (0.25 * basic);
    }

    public void salary() {
        this.salary = this.basic + this.da + this.hra;
        System.out.println(this.title + ": " + this.salary);
    }
}