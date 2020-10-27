# Mobilne Vypocty 2020

## Master (Branch)

Pouzitie ViewModel-View-Fragment, klasicky sposob pomocou Inflater-a.

Ref: HomeFragment.kt, HomeViewModel.kt, fragment_home.xml

## Viewmodel2020.1 (Branch)

Pouzitie ViewModel-View-Fragment, pomocou DataBinding-u

Ref: HomeFragment.kt, HomeViewModel.kt, fragment_home.xml

## Viewmodel2020.2 (Branch)

Pouzitie ViewModel-View-Fragment, pomocou DataBinding-u.  
Ukazka navrhoveho vzoru Repozitar. Spolupraca s databazou SQLite za pomoci Room.  
Pouzitie Navigation kniznice na presun medzi fragmentami.

Ref: HomeFragment.kt, DatabaseFragment.kt, DatabaseViewModel.kt, DataRepository.kt, ViewModelFactory.kt, Injection.kt, LocalCache.kt, DBDao.kt, AppRoomDatabase.kt, WordItem.kt, fragment_home.xml, fragment_database.xml, nav_graph.xml


## RecyclerView (Branch)

Pouzitie komponentu RecyclerView na zobrazenie skrolovatelneho zoznamu zaznamov.

Ref: DatabaseFragment.kt, DatabaseViewModel.kt, MessagesAdapter.kt, fragment_database.xml, text_item.xml


## DeleteUpdate (Branch)

Ukazka ako pouzivat upravu/vymazavanie dat v databaze.

Ref: DatabaseFragment.kt, DatabaseViewModel.kt, fragment_database.xml,  DataRepository.kt, LocalCache.kt, DBDao.kt


## DeleteUpdate (Branch)

Ukazka ako pouzivat upravu/vymazavanie dat v databaze.

Ref: DatabaseFragment.kt, DatabaseViewModel.kt, fragment_database.xml,  DataRepository.kt, LocalCache.kt, DBDao.kt

## InternetText (Branch)

Ukazka ako nacitavat udaje z Webservisu pomocou Retrofit v navrhovom vzore Repozitar a ukladat do lokalnej databazy.
Nasledne ziskane udaje z lokalnej databazy zobrazovat v RecyclerView.

Ref: DatabaseFragment.kt, DatabaseViewModel.kt, WebApi.kt, Responses.kt,   DataRepository.kt, LocalCache.kt, DBDao.kt,  Injection.kt, MarsAdapter.kt, MarsItem.kt, mars_item.xml

## InternetText (Branch)

Ukazka ako nacitavat udaje z Webservisu pomocou Retrofit v navrhovom vzore Repozitar a ukladat do lokalnej databazy.
Nasledne ziskane udaje z lokalnej databazy zobrazovat v RecyclerView.

Ref: DatabaseFragment.kt, DatabaseViewModel.kt,  WebApi.kt, Responses.kt,   DataRepository.kt, LocalCache.kt, DBDao.kt,  Injection.kt

## InternetDetail (Branch)

Rozsirenie riadkov v RecyclerView z TextView na ConstraintLayout a pridanie viacerych informacii.
Zobrazenie obrazku z internetu.

Ref: DatabaseFragment.kt, DatabaseViewModel.kt,  WebApi.kt, Responses.kt,   DataRepository.kt, LocalCache.kt, DBDao.kt,  Injection.kt, MarsAdapter.kt, MarsItem.kt, mars_item.xml


## InternetBinding (Branch)

InternetText pouzitim Databindingu

Ref: DatabaseFragment.kt, DatabaseViewModel.kt,  MarsAdapter.kt, MarsItem.kt, mars_item.xml

## InternetBindingDetail (Branch)

InternetDetail pouzitim Databindingu

Ref: DatabaseFragment.kt, DatabaseViewModel.kt,  MarsAdapter.kt, MarsItem.kt, mars_item.xml
