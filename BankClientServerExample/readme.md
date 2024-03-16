
Simple Headquarters Access Protocol (SBAP)

| Client Request        | Server Response                                | Description                                                                              |
|-----------------------|------------------------------------------------|------------------------------------------------------------------------------------------|
| GetHp heroId          | heroId and their current hp                    | Gets the hero by Id and returns their current hp                                         |
| Heal heroId, a        | heroId their new hp                            | Adds to heroes hp by amount(a)                                                           |
| Damage heroId, a      | heroID and their new hp - a                    | Subtracts heroes hp by amount(a)                                                         |
| Fight heroId, heroId2 | heroId, heroId2, heroId stamina and heroId2 hp | subtracts heroId2 hp by heroId attack power and subtracts heroId stamina by a set amount |
| Quit                  | Quit the connection                            |                                                                                          |