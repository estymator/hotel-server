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

#### /hotel/id -DELETE

id_hotelu

###Personel

#### /personel/add POST

-imie

-nazwisko

-email

-telefon


-id_hotelu(bez walidacji)

#### /personel/id DELETE

-id_personelu


#### /personel/id GET

-id_personelu/id_hotelu - zwraca osobe o danym id/osoby pracujące w hotelu o danym id


#### /personel/all GET

###Pokoj

#### /room/add POST

-ilosc_osob

-standart

-status

-id_hotelu

-cena

#### /room/id -GET
-id_pokoju

#### /room/booked -GET -zwraca zajete aktualnie pokoje

#### /room/available -GET -zwraca aktualnie wolne pokoje

#### /room/attribute -GET tylko wolne pokoje

-id_hotelu

-ilosc_osob

-standart

-cena_min

-cena_max

#### /room/id -DELETE

-id_pokoju

#### /room/update -PUT

-id_pokoju

-ilosc_osob

-standart

-status

-cena

###Klient

####klient/id -GET

-id_klienta

#### /klient/id -DELETE

-id_klienta

#### /klient/login -GET

-login

#### /klient/all -GET


###Rezerwacja

#### /reservation/add -POST

-id_pokoju

-id_klienta

-rodzaj

-stan

-data_rozpoczecia

-data_zakonczenia


#### /reservation/id -GET -zwraca wszystkie rezerwacje danego pokoju lub klienta

-id_hotelu/id_klienta

#### /reservation/id -GET

-id_pokoju

-id_klienta

#### /reservation/id -DELETE

-id_pokoju

-id_klienta

### Wydarzenia

#### /event/all -GET

#### /event/add -POST 

-id_pokoju

-id_personelu

-data_wydarzenia

-godzina_wydarzenia

-typ

#### /event/id -GET

-id_pokoju/id_personelu

#### /event/id -DELETE

-id_wydarzenia

###Opinie

#### /opinion/add -POST

-data_wystawienia

-gwiazdki

-id_hotelu

-tresc

#### /opinion/id -DELETE

-id_opinii

#### /opinion/id -GET
-id_hotelu


## License
[MIT](https://choosealicense.com/licenses/mit/)
