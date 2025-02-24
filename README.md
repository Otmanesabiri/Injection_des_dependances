# Injection des Dépendances

## Introduction
Ce projet démontre le principe d'injection des dépendances et d'inversion de contrôle à travers différentes approches d'implémentation.

## Structure du Projet
- `dao`: Couche d'accès aux données
- `metier`: Couche métier
- `presentation`: Différentes implémentations de l'instantiation

## Diagramme de Classes
```mermaid
classDiagram
    IDao <|.. DaoImpl
    IMetier <|.. MetierImpl
    MetierImpl --> IDao
    class IDao {
        +getData() double
    }
    class IMetier {
        +calcul() double
    }
```

## Implémentations
### 1. Injection Statique
```java
DaoImpl dao = new DaoImpl();
MetierImpl metier = new MetierImpl();
metier.setDao(dao);
```

### 2. Injection Dynamique
Utilise la réflexion pour charger les classes dynamiquement depuis un fichier de configuration.

### 3. Spring XML
Configuration via applicationContext.xml

### 4. Spring Annotations
Utilisation des annotations @Component et @Autowired

## Avantages et Inconvénients

### Injection Statique
✅ Simple à comprendre
❌ Couplage fort

### Injection Dynamique
✅ Flexible
❌ Complexe à maintenir

### Spring
✅ Standardisé
✅ Facile à maintenir
❌ Courbe d'apprentissage

## Conclusion
L'injection de dépendances permet de créer des applications modulaires et facilement testables.
