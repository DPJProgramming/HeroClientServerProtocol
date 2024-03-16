/**
 A place containing multiple heroes
 */
public class Headquarters
{
    private SuperHero[] superHeroes;

    /**
     Constructs a headquarters with a given number of heroes
     @param size the number of SuperHeroes
     */
    public Headquarters(int size)
    {
        superHeroes = new SuperHero[size];
        superHeroes[0] = new SuperHero("Spider-man", 6, 6, 7, 7,  3); //attack power out of 5
        superHeroes[1] = new SuperHero("Thor", 10, 10, 4, 4,  5);
        superHeroes[2] = new SuperHero("Captain America", 6, 6, 10, 10,  2);
        superHeroes[3] = new SuperHero("Hulk", 10, 10, 4, 4,  5);
        superHeroes[4] = new SuperHero("Wolverine", 8, 8, 7, 7,  3);
        superHeroes[5] = new SuperHero("Batman", 6, 6, 8, 8,  2);
        superHeroes[6] = new SuperHero("Cyclops", 5, 5, 5, 5,  4);
        superHeroes[7] = new SuperHero("Colossus", 9, 9, 6, 6,  4);
        superHeroes[8] = new SuperHero("She-Hulk", 8, 8, 5, 5,  4);
        superHeroes[9] = new SuperHero("Flash", 5, 5, 10, 10,  1);
    }

    /**
     heals a hero, increasing their hp
     @param heroId the unique identifier for each hero
     @param healAmount the amount to heal
     */
    public int heal(int heroId, int healAmount)
    {
        SuperHero hero = superHeroes[heroId];
        return hero.heal(healAmount);
    }

    /**
     sends damage to a hero lowering their hp.
     @param Id the identifier for each hero
     @param amount the amount of damage to take away from hp
     */
    public void damage(int Id, int amount)
    {
        SuperHero hero = superHeroes[Id];
        hero.damage(amount);
    }

    /**
     gets the remaining hp from hero
     @param id unique identifier for each hero
     @return the heroes current hp
     */
    public int getHp(int id)
    {
        return superHeroes[id].getHp();
    }

    /**
     gets the remaining hp from hero
     @param heroId1 the attacking hero
     @param heroId2 the defending hero
     */
    public void fight(int heroId1, int heroId2)
    {
        SuperHero hero1 = superHeroes[heroId1];

        if(hero1.getStamina() > 0) {
            hero1.attack();
            damage(heroId2, hero1.attackPower);
        }
        else{
            damage(heroId2, 0);
        }
    }

    /**
     gets the remaining stamina from hero
     @param id unique identifier for a hero
     */
    public int getStamina (int id){
        return superHeroes[id].getStamina();
    }

    /**
     gets specific hero from superHeroes array
     @param id unique identifier for a hero
     @return Superhero
     */
    public SuperHero getHero(int id){
        return superHeroes[id];
    }
}