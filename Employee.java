package Drake.Projes.Employee;

import java.time.LocalDate;

public class Employee {

     /*
        Java da fabrika çalışanlarını temsil eden bir class oluşturunuz.

        Class Name: Employee
        Nitelikleri:
        name: İşçi Adı
        salary: İşçi Maaşı
        workHours: Haftalık Çalışma Saati
        year: Çalışmaya Başladığı Yıl

        Metotları:
        Parametreli Constructor create edilmelidir. Sınıfın nitelikleri aynı zamanda constructor ın parametresi olmalıdır.

        vergi() → Maaşa uygulanan vergiyi hesaplamayabilen bir metot oluşturunuz.
        salary < 10000 $, vergi = 0
        salary >= 10000 $,vergi = (salary *3 /100)

       bonus() → Haftalık Çalışma Saatine göre bonus verilebilen bir metot oluşturunuz.
        workHours > 40,Her bir saate 50$

        maasArtis() → İşçinin işe başlangıç yılına göre maaş artışına etki edebilecek oranı hesaplayan bir metot oluşturunuz.

        5 yıldan az çalışıyor ise artis = ((salary + tax) *5)/100

        ** Maaş Artışlarına uygulanan vergiyi de dahil ediniz.
        [5-15) arası
        artis = ((salary + tax)  * 10)/100
        [+15-Now]
        artis = ((salary + tax)  * 20)/100

        toString() → Çalışanın bilgilerini konsola yazdıracak bir metot oluşturunuz (İşçi Adı, Maaş , Uygulanan Vergi, Toplam Maaş (Maaş + Bonus), Maaş Artışı)

     */

    String name;
    double salary;
    double workHours;
    int year;

    public Employee(String name, double salary, double workHours, int year) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.year = year;
    }

    public Employee() {
    }

    public double tax() {

        //  vergi() → Maaşa uygulanan vergiyi hesaplamayabilen bir metot oluşturunuz.
        //          salary < 10000 $, vergi = 0
        //  salary >= 10000 $,vergi = (salary *3 /100)

        double HesaplananTax = 0;
        if (salary < 10000) {
            HesaplananTax = 0;
        } else {
            HesaplananTax = (salary * 3) / 100;
        }
        return HesaplananTax;
    }


    public double bonus() {
        //  bonus() → Haftalık Çalışma Saatine göre bonus verilebilen bir metot oluşturunuz.
        //            workHours > 40,Her bir saate 50$
        double HesaplananBonus = 0;
        if (workHours > 40) {
            HesaplananBonus = (workHours - 40) * 50;
        }

        return HesaplananBonus;
    }


    public double maasArtis() {
        //    maasArtis() → İşçinin işe başlangıç yılına göre maaş artışına etki edebilecek oranı hesaplayan bir metot oluşturunuz.

        //    5 yıldan az çalışıyor ise artis = ((salary + tax) *5)/100

        //            ** Maaş Artışlarına uygulanan vergiyi de dahil ediniz.
        //     [5-15) arası
        //            artis = ((salary + tax)  * 10)/100
        //            [+15-Now]
        //    artis = ((salary + tax)  * 20)/100

        double HesaplananMaasArtis = 0;
        LocalDate bgn = LocalDate.now();

        if (bgn.getYear() - year < 5) {
            HesaplananMaasArtis = ((salary + tax()) * 5) / 100;
        } else if (bgn.getYear() - year < 15) {
            HesaplananMaasArtis = ((salary + tax()) * 10) / 100;
        } else {
            HesaplananMaasArtis = ((salary + tax()) * 20) / 100;
        }
        return HesaplananMaasArtis;
    }

    public double toplamMaas() {
        double tplmMaas = 0;
        tplmMaas = salary + bonus()+ maasArtis();
        return tplmMaas;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", workHours=" + workHours +
                ", year=" + year +
                ", toplam maas : " + toplamMaas() +
                ", maas artis : " + maasArtis() +
                ", Toplam vergi : "+ tax()+"}";

    }
}
