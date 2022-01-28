package com.sbrf.reboot.equalshashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EqualsHashCodeTest {

     class Car {
        String model;
        String color;
        Calendar releaseDate;
        int maxSpeed;

        @Override
        public boolean equals(Object o) {

            //Рефлексивность: объект должен равняться самому себе
            if (o == this)
                return true;
            /*  Сравнение null: для любого заданного значения объекта о вызов о.equals(null) должен возвращать false и
            "антипод" рефлексивности, то есть объект не должен равняться объекту другого класса */
            if (o == null || getClass() != o.getClass())
                return false;

            //  Симметричность: объект 1 равен/не равен объекту 2 и при этом объект 2 равен/не равен объекту 1
            /*  Транзитивность: объект 1 равен/не равен объекту 2 и равен/не равен объекту 3, следовательно объекты 2 и
            3 так же равны/не равны */
            Car car = (Car) o;

            /*  Согласованность: пока поля объектов 1 и 2 неизменны, результат метода equals() при каждом вызове будет
            идентичен */
            if (maxSpeed != car.maxSpeed)
                return false;

            return (model.equals(car.model) && color.equals(car.color) && releaseDate.equals(car.releaseDate));
        }

        /*  1. При вызове метода над одним и тем же объектом, всегда должен быть возвращен один и тот же хэш-код при
        условии неизменности полей */
        /*  2. При вызове метода над двумя одинаковыми объектами, всегда должен быть возвращен один и тот же хэш-код при
        условии неизменности полей */
        /*  3. При вызове метода над двумя неравными между собой объектами, для каждого из них должен быть возвращен
        уникальный хэш-код (не обязательное требование) */
         @Override
         public int hashCode() {
            int result = maxSpeed;
            result = 31 * result + (model == null ? 0 : model.hashCode());
            result = 31 * result + (color == null ? 0 : color.hashCode());
            result = 31 * result + (releaseDate == null ? 0 : releaseDate.hashCode());

            return result;
         }

     }

    @Test
    public  void assertTrueEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;


        Assertions.assertTrue(car1.equals(car2));
    }

    @Test
    public void assertFalseEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertFalse(car1.equals(car2));
    }

    @Test
    public void successEqualsHashCode(){
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertEquals(car1.hashCode(),car2.hashCode());

    }

    @Test
    public void failEqualsHashCode(){
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertNotEquals(car1.hashCode(),car2.hashCode());
    }

    //  Задание на 5+
    //  Тесты метода equals()
    //  Тест на рефлексивность
    @Test
    public void assertReflexivityEqualsTrue() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Assertions.assertTrue(car1.equals(car1));
    }

    //  Тесты на сравнение null
    @Test
    public void assertComparisonNullEqualsFalse() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Assertions.assertFalse(car1.equals(null));
    }

    @Test
    public void assertComparisonEmptyCarNullEqualsFalse() {
         Car car1 = new Car();

         Assertions.assertFalse(car1.equals(null));
    }

    //  Тест на симметричность (обратное проверяется в тесте assertTrueEquals())
    public void assertSymmetryEqualsTrue() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertTrue(car2.equals(car1));
    }

    //  Тест на транзитивность (car1 == car2 - это проверяется тестом assertEqualsTrue())
    @Test
    public void assertTransitivityEqualsTrue() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;

        Car car3 = new Car();
        car3.model = "Mercedes";
        car3.color = "black";
        car3.releaseDate = new GregorianCalendar(2020, 0, 25);
        car3.maxSpeed = 10;

        Assertions.assertTrue(car1.equals(car3) && car2.equals(car3));
    }

    //  Тесты для hashCode на идентичность хэш-кодов для одного и того же объекта при нескольких вызовах
    @Test
    public void successEqualsHashCodeForOneObject() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Assertions.assertEquals(car1.hashCode(), car1.hashCode());
    }

    @Test
    public void successEqualsHashCodeForOneObjectEmpty() {
        Car car1 = new Car();

        Assertions.assertEquals(car1.hashCode(), car1.hashCode());
    }
}
