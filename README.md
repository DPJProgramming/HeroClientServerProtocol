
Simple Headquarters Access Protocol (SBAP)

| Client Request        | Server Response                                | Description                                                                              |
|-----------------------|------------------------------------------------|------------------------------------------------------------------------------------------|
| GetHp heroId          | hero name and their current hp                    | Gets the hero by Id and returns their current hp                                         |
| Heal heroId, a        | hero name and their new hp                            | Adds to heroes hp by amount(a)                                                           |
| Damage heroId, a      | hero name and their new hp - a(amount)                    | Subtracts heroes hp by amount(a)                                                         |
| Fight heroId, heroId2 | hero 1 name, hero 2 name, hero 1 stamina and hero 2 hp | subtracts heroId2 hp by heroId attack power and subtracts heroId stamina by a set amount |
| Quit                  | Quit the connection                            |                                                                                          |
