# Задача:
Вам нужно написать небольшой модуль, который будет заниматься фильтрацией набора перелётов
согласно различным правилам. Правил фильтрации может быть очень много. 
Также наборы перелётов могут быть очень большими. 
Правила могут выбираться и задаваться динамически в зависимости от контекста выполнения операции фильтрации.

Поместите в main() такой проверочный код. Исключите из тестового набора перелёты по следующим правилам (по каждому правилу нужен отдельный вывод списка перелётов):
1.	вылет до текущего момента времени
2.	имеются сегменты с датой прилёта раньше даты вылета
3.	общее время, проведённое на земле превышает два часа (время на земле — 
это интервал между прилётом одного сегмента и вылетом следующего за ним)


# Решение:

Для решения данной задачи, были созданы интерфейс, для шаблонизации реализации классов фильтрации, 3 класса фильтров, 
для решения поставленной задачи. Так как в задаче сказано, что на вход может подаваться "очень много правил фильтраций", был придуман инициализатор, 
который принимает на вход лист всех полетов, созданный из FlightBuilder, и список фильтров, которые будут фильтровать наши полеты, 
чтобы вывести нужный нам конечный список. Для удобства был создан удобный билдер, который принимает на вход динамическое количество фильтров, 
из которых создается список, подаваемый в инициализатор. Был реализован класс Main, который продемонстрирует работу программы. 
Данный код был покрыт тестами JUnit, можно проверить в папке test.   

