/**
 A place containing multiple heroes
 */
public class Headquarters
{
    private SuperHero[] superHeroes;

    /**
     Constructs a headquarters with a given number of heroes
     @param size the number of accounts
     */
    public Headquarters(int size)
    {
        superHeroes = new SuperHero[size];
        for (int i = 0; i < superHeroes.length; i++)
        {
            superHeroes[i] = new SuperHero();
        }
    }

    /**
     heals a hero, increasing their hp
     @param heroId the unique identifier for each hero
     @param healAmount the amount to heal
     */
    public int heal(int heroId, int healAmount)
    {
        SuperHero hero = superHeroes[heroId];
        if(hero.Hp + healAmount >= hero.maxHp){
            hero.Hp = hero.maxHp;
        }
        else{
            hero.Hp += healAmount;
        }
        return hero.Hp;
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
     @param accountNumber the account number
     @return the account balance
     */
    public double getHp(int accountNumber)
    {
        SuperHero account = superHeroes[accountNumber];
        return account.getHp();
    }

    /**
     gets the remaining hp from hero
     @param heroId1 the attacking hero
     @param heroId2 the defending hero
     @return the account balance
     */
    public String fight(int heroId1, int heroId2)
    {
        SuperHero hero1 = superHeroes[heroId1];
        SuperHero hero2 = superHeroes[heroId2];


        return hero1.name + " attacks " + hero2.name + "/n"
                + hero1.name + " has " + hero1.getStamina() + " left and "
                + hero2.name + " has " + hero2.getHp() + " left.";
    }
}