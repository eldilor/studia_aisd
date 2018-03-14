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