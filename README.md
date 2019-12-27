# hotel-server


## Execute

```bash
./gradlew bootRun
```

## Build jar

```bash
./gradlew build
```

## Endpoints

###Rejestracja i logowanie

#### /register POST

-imie 
-nazwisko
-telefon
-email
-login
-haslo

bez walidacji, haslo szyfrowane bcrypt

#### /login  POST
-login 

-haslo

bez walidacji, haslo szyfrowane bcrypt

#### /logout 
zakonczenie sesji
###Hotele

#### /hotel/add POST

-nazwa
-adres
-email
-telefon

#### /hotel/all GET

zwraca wszystkie hotele zapisane w bazie

###Personel

#### /personel/add POST

-imie
-nazwisko
-email
-telefon

-idHotelu(bez walidacji)

#### /personel/id DELETE

-idPersonelu


#### /personel/id GET

-idPersonelu/idHotelu - zwraca osobe o danym id/osoby pracujące w hotelu o danym id


#### /personel/all GET

###Pokoj

#### /room/add POST

-iloscOsob
-standart
-status
-idHotelu

#### /room/id -GET
-idPokoju

#### /room/booked -GET -zwraca zajete aktualnie pokoje

#### /room/available -GET -zwraca wolne pokoje

#### /room/attribute -GET tylko wolne pokoje
-idHotelu
-iloscOsob
-standart

###Klient

####klient/id Get
-idKlienta

#### klient/login Get
-login

#### klient/all


###Rezerwacja

#### /reservation/add -POST
-idPokoju
-idKlienta
-rodzaj
-stan
-dataRozpoczecia
-dataZakonczenia

#### /reservation/id -GET -zwraca wszystkie rezerwacje danego pokoju lub klienta
-idHotelu/idKlienta
#### /reservation/id -GET
-idPokoju
-idKlienta

#### /reservation/id -DELETE
-idPokoju
-idKlienta

### Wydarzenia

#### /event/all -GET

#### /event/add -POST 
-idPokoju
-idPersonelu
-dataWydarzenia
-godzinaWydarzenia
-typ

#### /event/id -GET
-idPokoju/idPersonelu
## License
[MIT](https://choosealicense.com/licenses/mit/)
