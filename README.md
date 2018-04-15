# Algorytmy i Struktury Danych
Informatyka PWr, semestr II 2017/2018

## Zadanie 2
Napisz program tworzący listę, której elementami są karty do gry. <br>
Wartosc = {1, 2, ... , 13} <br>
1 - As, 2 - 2, ... , 12 - Dama, 13 - Król <br>
Kolor = {0, 1, 2, 3} <br>
0 - Kier, 1 - Karo, 2 - Trefl, 3 - Pik

Dane do listy należy wylosować. Losujemy wartości pól: Wartosc [0,13] oraz Kolor
[0,3]. Wylosowanie wartości zero dla pola Wartosc oznacza koniec tworzenia listy.
Utworzoną kartę należy wstawić do listy na odpowiednie miejsce, tak aby karty były
uporządkowane według wartości, a następnie według kolorów. Do implementacji listy
wykorzystaj klasę ArrayList. Do przeglądania i odczytywania danych z listy wykorzystaj
pętle (for, while, foreach) oraz iterator. W programie zdefiniuj Menu, którego
opcje wykonują następujące operacje:

<ul>
    <li>Utworzenie listy</li>
    <li>Wyświetlanie listy</li>
    <li>Wyświetlanie liczby elementów listy</li>
    <li>Wyświetlanie kart o podanej wartości</li>
    <li>Wyświetlanie kart o podanym kolorze</li>
</ul>

#### Dodatkowo na zajęciach:
Utwórz metodę, która będzie usuwała duplikaty kart z talii. Przez duplikat rozumiemy
kartę o tej samej wartości i kolorze.

## Zadanie 3
Zaimplementować listę z zadania 2 jako listę pojedynczo wiązaną. 
Dodać Menu, którego opcje wykonują następujące operacje:
<ul>
    <li>Utworzenie listy</li>
    <li>Wyświetlanie listy</li>
    <li>Wyświetlanie liczby elementów listy</li>
    <li>Wyświetlanie kart o podanej wartości</li>
    <li>Wyświetlanie kart o podanym kolorze</li>
</ul>

#### Dodatkowo na zajęciach:
Do karty dodać pole ,które mówi czy karta jest zakryta, czy odkryta. Dodać karte Joker 
z wartością 14 i przy tworzeniu jest zakryta. Domyślnie reszta kart jest odkrytych. Karta 
zakryta ma się wyświetlać jako `()`. Do menu dodać opcje wyświetlania liczby kart zakrytych 
i odkrytych, opcję usuwania kart zakrytych, opcje usuwania duplikatów.

## Zadanie 4
Napisz program, w którym będą zdefiniowane dwa procesy: magazyn i klient. Magazyn
tworzy ogólnodostępną kolejkę FIFO i czeka na zgłoszenia klientów.
Każdy klient tworzy własną kolejkę, poprzez którą będzie podawał swoje zamówienia.
Element zamówienia zawiera nazwę towaru, liczbę sztuk i cenę jednostkową. Zgłoszenie
klienta polega na podaniu nazwy klienta i referencji do własnej kolejki.
Magazyn realizuje zgłoszenie klienta pobierając element ze swojej kolejki, następnie pobiera
kolejne elementy z kolejki klienta, oblicza kwotę do zapłaty za zamówienie. Następnie
wyświetla komunikat: „Zlecenie zrealizowane:” Nazwa klienta, „ kwota do zapłaty” = kwota.

W programie zdefiniuj:
 interfejs generyczny Queue z metodami:
o insert()
– wstawia element na koniec kolejki
o remove()
– usuwa element z początku kolejki
o isEmpty()
– zwraca true, jeśli kolejka pusta
o isFull()
– zwraca true, jeśli kolejka pełna
 klasę Kolejka implementującą interfejs Queue, stosując listę jednokierunkową (singly
linked).

#### Dodatkowo na zajęciach:
Dodać klasę Firma, która posiada daną liczbę magazynów. Zaimplementować metodę przychodu - 
sumy wszystkich zamówień ze wszystkich magazynów.

## Zadanie 5
Napisać program zamieniający napis z działaniami matematycznymi na
odwróconą notację polską i liczący wynik operacji.

#### Dodatkowo na zajęciach:
((2+3)*2+2)%5 = 23+2*2+5% = 2
((10+2)*(2+3))/10 = 10 2+23+*10/ = 6
(2+2)/(2-2) = 22+22-/ = pokazać błąd

Dodać nawiasy: {}, [] i sprawdzać, czy nawiasy się zgadzają.

## Zadanie 7
Napisz program sortujący tablicę liczb całkowitych (5000 lub więcej elementów) różnymi
metodami.
Metody: InsertSort, BubbleSort, SelectSort, QuickSort, HeapSort, MergeSort.

Każdy z algorytmów ma być wywołany trzykrotnie:
- dla danych losowych
- dla danych posortowanych rosnąco
- dla danych posortowanych malejąco

Program ma prowadzić pomiar czasów sortowania.