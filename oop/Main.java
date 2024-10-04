package tasks.oop;

import java.io.*;
import java.util.*;

class Person {
    private String name;
    private String age;
    private String gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

// 2 task
class Worker extends Person {
    private int salary;
}
class Manager extends Worker {
    List<Worker> workers;
}

// 3 task
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

class Cow implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Mooo");
    }
}

class Polymorphism {
    public void start() {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Cow();
    }
}

// 4 task
abstract class Transport {
    abstract void move();
}

class Bike extends Transport {
    @Override
    void move() {
        System.out.println("Bike is moving...");
    }
}

class Car extends Transport {
    @Override
    void move() {
        System.out.println("Car is moving...");
    }
}

// 5 task
class Book {
    protected String tittle;
    protected String author;
    protected int year;
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBookByAuthor(String name) {
        return books.stream().filter(book -> book.tittle.equals(name)).toList();
    }

    public List<Book> getBookByYear(int year) {
        return books.stream().filter(book -> book.year == year).toList();
    }
}

// 6 task
class BankAccout {
    private int accountNumber;
    private int balance;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

// 7 task
class Counter {
    static int counter = 0;

    public Counter() {
        counter++;
    }
}

// 8 task
abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    int r;
    @Override
    double getArea() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    int a;
    int b;

    @Override
    double getArea() {
        return a * b;
    }
}

// Task 9
abstract class AAnimal {
    abstract void move();
}

class Fish extends AAnimal {
    @Override
    void move() {
        System.out.println("Swimming...");
    }
}

class Bird extends AAnimal {
    @Override
    void move() {
        System.out.println("Flying...");
    }
}

class DDog extends AAnimal {
    @Override
    void move() {
        System.out.println("Running...");
    }
}

// Task 10
class Student {
    String name;
    String group;
    double grade;
}

class University {
    private List<Student> students;

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortStudentsByName() {
        students.sort(Comparator.comparing(student -> student.name));
    }

    public List<Student> filterByGrade(double grade) {
        return students.stream().filter(student -> student.grade == grade).toList();
    }
}

// Task 11
class Product {
    String name;
    double price;
    int quantity;
}

class Shop {
    private List<Product> products;

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(String name) {
        products.removeIf(x -> x.name.equals(name));
    }

    public List<Product> findByName(String name) {
        return products.stream().filter(book -> book.name.equals(name)).toList();
    }
}

// Task 12
interface PaymentSystem {
    void pay(int money);
    void refund(int money);
}

class CreditCard implements PaymentSystem {
    private int balance;
    @Override
    public void pay(int money) {
        System.out.println("Pay by credit card");
        balance -= money;
    }

    @Override
    public void refund(int money) {
        System.out.println("Refund by credit card");
        balance += money;
    }
}

class PayPal implements PaymentSystem {
    private int balance;
    @Override
    public void pay(int money) {
        System.out.println("Pay by PayPal");
        balance -= money;
    }

    @Override
    public void refund(int money) {
        System.out.println("Refund by PayPal");
        balance += money;
    }
}

// Task 13
class UniqueID {
    private static long cnt = 0;

    public long getUniqueID() {
        return cnt++;
    }
}

// Task 14
class Point {
    int x;
    int y;
}

class RRectangle {
    Point leftUp;
    Point rightDown;

    public int getArea() {
        int a = Math.abs(leftUp.x - rightDown.x);
        int b = Math.abs(leftUp.y - rightDown.y);

        return a * b;
    }
}

// Task 15
class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double divisor = other.real * other.real + other.imaginary * other.imaginary;

        if (divisor == 0) {
            throw new ArithmeticException();
        }

        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / divisor;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / divisor;
        return new ComplexNumber(newReal, newImaginary);
    }
}

// Task 16
class Matrix {
    private final int[][] data;
    private final int n;
    private final int m;

    public Matrix(int n, int m) {
        data = new int[n][m];
        this.n = n;
        this.m = m;
    }

    public Matrix(int[][] data) {
        this.data = Arrays.copyOf(data, data.length);
        this.n = data.length;
        this.m = data[0].length;
    }

    public Matrix add(Matrix matrix) {
        if (matrix.n != n || matrix.m != m) {
            throw new IllegalArgumentException("Некорректный размер матрицы");
        }

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = data[i][j] + matrix.data[i][j];
            }
        }

        return new Matrix(arr);
    }

    public Matrix multiply(Matrix matrix) {
        if (n != matrix.m) {
            throw new IllegalArgumentException("Некорректный размер матрицы");
        }

        int[][] arr = new int[n][matrix.m];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                int sum = 0;

                for (int k = 0; k < m; k++) {
                    sum += data[i][k] * matrix.data[k][j];
                }
                arr[i][j] = sum;
            }
        }

        return new Matrix(arr);
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "data=" + Arrays.deepToString(data) +
                ", n=" + n +
                ", m=" + m +
                '}';
    }
}

// Task 17
abstract class Weapon {
    protected int damage;

    abstract void shoot();
}

class Pistol extends Weapon {
    public Pistol() {
        damage = 10;
    }

    @Override
    void shoot() {
        System.out.println("Shooting with pistol");
    }
}

class RocketLauncher extends Weapon {
    public RocketLauncher() {
        damage = 100;
    }

    @Override
    void shoot() {
        System.out.println("Shooting with rocket launcher");
    }
}

abstract class Entity {
    protected int hp;
    protected Weapon weapon;

    public void attack(Entity entity) {
        weapon.shoot();
        entity.hp -= weapon.damage;
    }
}

class Player extends Entity {
    public Player() {
        hp = 100;
        weapon = new Pistol();
    }
}

class Enemy extends Entity {
    public Enemy() {
        hp = 1000;
        weapon = new RocketLauncher();
    }
}

// Task 18
abstract class AbstractProduct {
    protected int price;

    protected String name;
}

class IPhone extends AbstractProduct {
    public IPhone() {
        price = 100000000;
        name = "Iphone 16 Pro MaX";
    }
}

class Bottle extends AbstractProduct {
    public Bottle() {
        price = 350;
        name = "Bottle";
    }
}

class Order {
    protected long id;
    private List<AbstractProduct> products = new ArrayList<>();
    private int totalSum;

    public void addProduct(AbstractProduct product) {
        products.add(product);
        totalSum += product.price;
    }

    public int getTotalSum() {
        return totalSum;
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrderHistory() {
        return orders;
    }

    public Order getOrderById(long id) {
        return orders.stream().filter(order -> order.id == id).findFirst().orElseThrow();
    }
}

// Task 19
abstract class Device {
    protected String brand;

    abstract void turnOn();
    abstract void turnOff();
}

class Smartphone extends Device {
    @Override
    void turnOn() {
        System.out.println("Smartphone turned on");
    }

    @Override
    void turnOff() {
        System.out.println("Smartphone turned off");
    }

    void takePhoto() {
        System.out.println("Smartphone took photo");
    }
}

class Laptop extends Device {
    private boolean isCapsLockTurned = false;

    @Override
    void turnOn() {
        System.out.println("Laptop turned on");
    }

    @Override
    void turnOff() {
        System.out.println("Laptop turned off");
    }

    void capsLock() {
        isCapsLockTurned = !isCapsLockTurned;
        System.out.println("Switch caps lock");
    }
}

// Task 20
class Game {
    private static class Board {
        private final Character[][] board = new Character[3][3];
        private static final char WINNER_SIGN = '⬜';

        // 0  0 1 2    1 2 3
        // 1  0 1 2    4 5 6
        // 2  0 1 2    7 8 9

        public void set(int cell, char sign) {
            int[] indexes = getIndexes(cell);

            int i = indexes[0];
            int j = indexes[1];

            board[i][j] = sign;
        }

        private int[] getIndexes(int cell) {
            return new int[] {(cell - 1) / 3, (cell - 1) % 3};
        }

        private Character getValue(int cell) {
            int[] indexes = getIndexes(cell);

            int i = indexes[0];
            int j = indexes[1];

            return board[i][j];
        }

        public boolean isFree(int cell) {
            if (cell == 0) {
                return false;
            }

            return getValue(cell) == null;
        }

        public Character getWinner() {
            for (int i = 0; i < 3; i++) {
                if (cellEquals(board[i][0], board[i][1], board[i][2])) {
                    board[i][0] = WINNER_SIGN;
                    board[i][1] = WINNER_SIGN;
                    board[i][2] = WINNER_SIGN;
                    return board[i][0];
                }

                if (cellEquals(board[0][i], board[1][i], board[2][i])) {
                    board[0][i] = WINNER_SIGN;
                    board[1][i] = WINNER_SIGN;
                    board[2][i] = WINNER_SIGN;
                    return board[0][i];
                }
            }

            if (cellEquals(board[0][0], board[1][1], board[2][2])) {
                board[0][0] = WINNER_SIGN;
                board[1][1] = WINNER_SIGN;
                board[2][2] = WINNER_SIGN;
                return board[1][1];
            }

            if (cellEquals(board[0][2], board[1][1], board[2][0])) {
                board[0][2] = WINNER_SIGN;
                board[1][1] = WINNER_SIGN;
                board[2][0] = WINNER_SIGN;
            }

            return null;
        }


        public boolean cellEquals(Character a, Character b, Character c) {
            if (a == null || b == null || c == null) {
                return false;
            }
            return a.equals(b) && a.equals(c);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Character c = board[i][j];

                    if (c == null) {
                        sb.append(" ");
                    } else {
                        sb.append(c);
                    }

                    sb.append(" | ");
                }

                sb.append("\n");
            }

            return sb.toString();
        }
    }
    private Board board;
    private AbstractPlayer firstPlayer;
    private AbstractPlayer secondPlayer;
    private AbstractPlayer winner;
    void start() {
        board = new Board();
        firstPlayer = new ConsolePlayer("First", 'O');
        secondPlayer = new ConsolePlayer("Second", 'X');
        sendToPlayers("Начало игры");
        sendToPlayers(board.toString());
        runLoop();
        sendToPlayers("Конец игры");
        sendToPlayers(board.toString());
    }

    void runLoop() {
        while (!isEnd()) {
            int cell = 0;

            while (!board.isFree(cell)) {
                cell = firstPlayer.getCell();
            }

            board.set(cell, firstPlayer.getSign());
            sendToPlayers(board.toString());
            sendToPlayers("Первый игрок пошёл");

            if (isEnd()) {
                break;
            }

            while (!board.isFree(cell)) {
                cell = secondPlayer.getCell();
            }

            board.set(cell, secondPlayer.getSign());
            sendToPlayers(board.toString());
            sendToPlayers("Второй игрок пошёл");
        }

        winner.setWins(winner.getWins() + 1);
        String text = String.format("Победитель - %s. У него теперь %d побед", winner.getName(), winner.getWins());
        sendToPlayers(text);
    }

    void sendToPlayers(String text) {
        firstPlayer.send(text);
        secondPlayer.send(text);
    }

    boolean isEnd() {
        Character boardWinner = board.getWinner();
        if (boardWinner == null) {
            return false;
        }

        if (boardWinner == firstPlayer.getSign()) {
            winner = firstPlayer;
        } else {
            winner = secondPlayer;
        }

        return true;
    }
}

abstract class AbstractPlayer {
    private final char sign;
    private final String name;
    private int wins;
    protected BufferedReader reader;
    protected PrintWriter printer;

    public AbstractPlayer(String name, char sign, InputStream inputStream, OutputStream outputStream) {
        this.name = name;
        this.sign = sign;
        printer = new PrintWriter(new OutputStreamWriter(outputStream));
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public int getCell() {
        return promptCell("Укажите клетку (1-9) чтобы поставить " + sign);
    }

    public void send(String text) {
        printer.println(text);
        printer.flush();
    }

    private int promptCell(String text) {
        send(text);
        int cell;

        try {
            cell = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cell;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public char getSign() {
        return sign;
    }
}

class ConsolePlayer extends AbstractPlayer {
    public ConsolePlayer(String name, char sign) {
        super(name, sign, System.in, System.out);
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
