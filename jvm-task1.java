//ClassLoader - загрузка классов System, Integer, Object, JvmComprehension в Metaspace
public class JvmComprehension {

//Создание в области памяти stack фрейма main()
    public static void main(String[] args) {
        int i = 1;                      // 1 создание в фрейме main() переменной i 
        Object o = new Object();        // 2 создание в области heap фрейма Obiect и в stack main() ссылки o 
        Integer ii = 2;                 // 3 создание в heap фрейма Integet, и в stack main() ссылки ii и присвоение значения 2
        printAll(o, i, ii);             // 4 создание в stack фрейма printAll(), создание в фрейме printAll() ссылок o на Object, ii на Integer из heap области
        System.out.println("finished"); // 7 сборка мусора - удаление объектов o, ii, создание в stack нового фрейма
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 создание в фрейме printAll() stack ссылки uselessVar на фрейм Integer из heap 
        System.out.println(o.toString() + i + ii);  // 6 создание в stack нового фрейма и передача в него ссылок o и ii  и значения i из stack
//сборщик мусора удаляет объект uselessVar 
    }
}



