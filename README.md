# Java_HW
# Тесты к курсу «Введение в программирование»

[Условия домашних заданий]


## Домашнее задание 11. Выражения

Модификации
 * *Base*
    * Реализуйте интерфейс [Expression](java/expression/Expression.java)
    * [Исходный код тестов](java/expression/ExpressionTest.java)
        * Первый аргумент: `easy` или `hard`
        * Последующие аргументы: модификации
 * *Triple* 
    * Дополнительно реализуйте поддержку выражений с тремя переменными: `x`, `y` и `z`.
    * Интерфейс [TripleExpression](java/expression/TripleExpression.java).


## Домашнее задание 10. Игра m,n,k


Модификации

 * *Матчи* 
    * Добавьте поддержку матчей: последовательность игр до указанного числа побед.
    * Стороны в матче должны меняться каждую игру.


## Домашнее задание 9. Markdown to HTML

Модификации
 * *Базовая*
    * [Исходный код тестов](java/md2html/Md2HtmlTester.java)
    * [Откомпилированные тесты](artifacts/Md2HtmlTest.jar)
        * Аргументы командной строки: модификации
 * *Var* 
    * Добавьте поддержку `%переменных%`: `<var>переменных</var>`


## Домашнее задание 7. Разметка

Модификации
 * *Base*
    * Исходный код тестов:
        * [MarkupTester.java](java/markup/MarkupTester.java)
        * [MarkupTest.java](java/markup/MarkupTest.java)
        * Аргументы командной строки: модификации
    * [Исходный код тестов](java/markup/MarkupListTest.java)
 * *BBCode* 
    * Дополнительно реализуйте метод `toBBCode`, генерирующий [BBCode](https://en.wikipedia.org/wiki/BBCode)-разметку:
      * выделеный текст окружается тегом `i`;
      * сильно выделеный текст окружается тегом `b`;
      * зачеркнутый текст окружается тегом `s`.

## Домашнее задание 6. Подсчет слов++

Модификации
 * *Base*
    * Класс должен иметь имя `Wspp`
    * Исходный код тестов: 
        [WsppTest.java](java/wspp/WsppTest.java), 
        [WsppTester.java](java/wspp/WsppTester.java)
    * Откомпилированные тесты: [WsppTest.jar](artifacts/WsppTest.jar)
        * Аргументы командной строки: модификации
 * *Position* 
    * Вместо номеров вхождений во всем файле надо указывать
      `<номер строки>:<номер в строке>`
    * Класс должен иметь имя `WsppPosition`



## Домашнее задание 5. Свой сканнер

Модификации
 * *Base*
    * Исходный код тестов: [FastReverseTest.java](java/reverse/FastReverseTest.java)
    * Откомпилированные тесты: [FastReverseTest.jar](artifacts/FastReverseTest.jar)
        * Аргументы командной строки: модификации
 * *Abc2* 
    * Во вводе и выводе используются числа, записаные буквами:
      нулю соответствует буква `a`, единице – `b` и так далее
    * Класс должен иметь имя `ReverseAbc2`


## Домашнее задание 4. Подсчет слов

Модификации
 * *Base*
    * Класс должен иметь имя `WordStatInput`
    * Исходный код тестов:
        [WordStatTest.java](java/wordStat/WordStatTest.java),
        [WordStatTester.java](java/wordStat/WordStatTester.java),
        [WordStatChecker.java](java/wordStat/WordStatChecker.java)
    * Откомпилированные тесты: [WordStatTest.jar](artifacts/WordStatTest.jar)
        * Аргументы командной строки: модификации
 * *Words* 
    * В выходном файле слова должны быть упорядочены в лексикографическом порядке
    * Класс должен иметь имя `WordStatWords`.


## Домашнее задание 3. Реверс

Модификации
 * *Base*
    * Исходный код тестов:
        [ReverseTest.java](java/reverse/ReverseTest.java),
        [ReverseTester.java](java/reverse/ReverseTester.java)
    * Откомпилированные тесты: [ReverseTest.jar](artifacts/ReverseTest.jar)
        * Аргументы командной строки: модификации
 * *Odd2*
    * Выведите (в реверсивном порядке) только числа, 
      у которых сумма номеров строки и столбца нечетная
    * Класс должен иметь имя `ReverseOdd2`


## Домашнее задание 2. Сумма чисел

Модификации
 * *Long* )
    * Входные данные являются 64-битными целыми числами
    * Класс должен иметь имя `SumLong`

Для того, чтобы протестировать исходную программу:

 1. Скачайте откомпилированные тесты ([SumTest.jar](artifacts/SumTest.jar))
 1. Откомпилируйте `Sum.java`
 1. Проверьте, что создался `Sum.class`
 1. В каталоге, в котором находится `Sum.class` выполните команду
    ```
       java -jar <путь к SumTest.jar> Base
    ```
    * Например, если `SumTest.jar` находится в текущем каталоге, выполните команду
    ```
        java -jar SumTest.jar Base
    ```

Исходный код тестов:

* [SumTest.java](java/sum/SumTest.java)
* [SumTester.java](java/sum/SumTester.java)
* [Базовые классы](java/base/)


