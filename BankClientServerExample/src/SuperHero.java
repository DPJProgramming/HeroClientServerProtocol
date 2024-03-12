import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 A SuperHero has Hp which can be raised or lowered up to the maxHp to 0.
 stamina lowers with each attack they perform
 */
public class SuperHero
{
    public String name;
    public int Hp;
    public int maxHp;
    public int stamina;
    public int maxStamina;
    public int attackPower;

    /**
     Constructs a SuperHero with default attributes.
     */
    public SuperHero()
    {
        Hp = 11;
        name = "hero";
        maxHp = 10;
        stamina = 10;
        attackPower = 2;
    }

    /**
     Constructs a SuperHero with given attributes.
     @param name the hero's name
     @param Hp the hero's initial Hp
     @param maxHp the hero's maxHp
     @param stamina the hero's stamina
     @param maxStamina the hero's maxStamina
     */
    public SuperHero(String name, int Hp, int maxHp, int stamina, int maxStamina, int attackPower)
    {
        this.name = name;
        this.Hp = Hp;
        this.maxHp = maxHp;
        this.stamina = stamina;
        this.maxStamina = maxStamina;
        this.attackPower = attackPower;
    }

    /**
     heals a hero, increasing their hp
     @param healAmount the amount to heal
     */
    public void heal(int healAmount)
    {
        if(Hp + healAmount > maxHp){
            Hp = maxHp;
        }
        else{
            Hp = maxHp;
        }
    }


    /**
     subtracts hp from hero
     @param amount the amount to withdraw
     */
    public void damage(int amount)
    {
        int newHp = Hp - amount;
        if(newHp >= 0) {
            Hp -= amount;
        }
        else{
            Hp = 0;
        }
    }

    /**
     Gets the current hp of hero
     @return the current balance
     */
    public int getHp()
    {
        return Hp;
    }

    /**
     Gets the current hp of hero
     @return the current balance
     */
    public int attack()
    {
        return stamina - 1;
    }

    /**
     Gets the current stamina of hero
     @return the current stamina
     */
    public int getStamina()
    {
        return stamina;
    }
}