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

-nr_telefonu

-adres_mail

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

-adres_mail

-nr_telefonu

-zdjecie


#### /hotel/all GET

zwraca wszystkie hotele zapisane w bazie

#### /hotel/id -DELETE

id_hotelu

#### /hotel.id -GET

-id_hotelu

#### /hotel/update -PUT

-id_hotelu

-nazwa

-adres

-adres_mail

-nr_telefonu

-zdjecie

###Personel

#### /personel/add POST

-imie

-nazwisko

-adres_mail

-nr_telefonu

-pensja

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

-id_hotelu

-zdjecie

-cena

#### /room/id -GET
-id_pokoju


#### /room/available -GET -Jeśli termin jest zajety zwraca liste kolidujących rezerwacji

-id_pokoju

-data_rozpoczecia yyyy-mm-dd

-data_zakonczenia yyyy-mm-dd

#### /room/attribute -GET 

-id_hotelu

-ilosc_osob

-standart

-cena_min

-cena_max

#### /room/attribute -GET 

-id_hotelu

#### /room/id -DELETE

-id_pokoju

#### /room/update -PUT

-id_pokoju

-ilosc_osob

-standart

-zdjecie

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

-data_rozpoczecia yyyy-mm-dd

-data_zakonczenia yyyy-mm-dd


#### /reservation/id -GET -zwraca wszystkie rezerwacje danego pokoju lub klienta

-id_pokoju/id_klienta/id_hotelu

#### /reservation/id -GET

-id_pokoju

-id_klienta

#### /reservation/id -DELETE

-id_rezerwacji

### Wydarzenia

#### /event/all -GET

#### /event/add -POST 

-id_pokoju

-id_personelu

-start_wydarzenia yyyy-mm-dd

-koniec_wydarzenia yyyy-mm-dd

-tytul

-tresc

-kolor

#### /event/id -GET

-id_pokoju/id_personelu/id_wydarzenia

#### /event/id -DELETE

-id_wydarzenia

#### /event/update -PUT

-id_wydarzenia

-start_wydarzenia yyyy-mm-dd

-koniec_wydarzenia yyyy-mm-dd

-tytul

-tresc

-kolor

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

### Posilki

#### /meal/all -GET

#### /meal/id -GET

-id_menu/id_posilku

#### /meal/id -DELETE

-id_posilku

#### /meal/name -DELETE

-nazwa

#### /meal/add -POST

-id_menu

-nazwa

#### /meal/update -PUT

-id_posilku

-id_menu

-nazwa

###Menu

#### /menu/all -GET

#### /menu/id -DELETE

-id_menu

#### /menu/id -GET

-id_menu/id_hotelu

#### /menu/add POST

-id_hotelu


## License
[MIT](https://choosealicense.com/licenses/mit/)
