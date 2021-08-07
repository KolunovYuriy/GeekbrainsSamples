package ru.geekbrains.samples.lesson2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cat {
        int age;
        String name;

        @Override
        public String toString() {
            return String.format("ru.geekbrains.Cat(a=%d,n=%s)", age, name);
        }
    
}
