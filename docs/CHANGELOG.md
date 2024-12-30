# The Aether - NeoForge - 1.21.1-1.5.1

Additions

- Added a new common server option `"Overworld-length Aether time cycle"` for changing the Aether's time from 3-times the length of the Overworld's day cycle to the same length as it.
- Added a new common server option `"Syncs time cycles"` for making the Aether's time sync with the Overworld's when it hits noon after eternal day has been banished.
- Added a new common client option `"Disables Aether's clouds"` for configuring whether clouds should render in the Aether dimension.
- Added a new tag `ores_in_ground/holystone` for Aether ores.
- Compatibility with Immersive Portals.
- Update de_at translation.
- Update en_ud translation.
- Update es_es translation.
- Update es_mx translation.
- Update fr_fr translation.
- Update it_it translation.
- Update ja_jp translation.
- Update ko_kr translation.
- Update lol_us translation.
- Update ms_my translation.
- Update pl_pl translation.
- Update ru_ru translation.
- Update sk_sk translation.
- Update sv_se translation.
- Update tok translation.
- Update uk_ua translation.
- Update zh_cn translation.

Fixes

- Fix mount mid-air jumps being triggered when jumping from the ground.
- Fix Sun Spirit and Fire Minion audio not playing.
- Fix the Aether Portal trigger sound not playing.
- Fix some discs playing in stereo mode.
- Fix Slider velocity being slower than it should be.
- Fix Aerwhales getting stuck on overhangs.
- Fix movement keys that cancel each other still disabling the Shield of Repulsion without moving.
- Fix TNT Presents having incorrect gravity.
- Fix Dart Shooters not accepting Infinity in creative mode.
- Fix Aether materials not working with new armor trims.
- Fix Skyroot Poison and Remedy Buckets not being in the `buckets` tag.
- Fix Skyroot Buckets not being in the `buckets/empty` tag.
- Fix a crash when trying to load a loot modifier asynchronously.
- Fix Supplementaries compatibility.

# The Aether - NeoForge - 1.21.1-1.5.1-beta.4

Changes

- Update Cumulus to 2.0.0. This includes a rework to the menu registration and the movement of world preview system code from Aether to Cumulus. The Aether/Minecraft Theme button is also now replaced by Cumulus' Menu List button.

Fixes

- Fix Altar and Freezer output not working correctly.
- Fix the eternal day check for sleeping in the Aether.
- Fix Valkyrie Lance being enchantable with Sweeping Edge.
- Fix meat drops from Aether animals not being cooked when killed with Fire Aspect in one hit.
- Fix a desync with the Aether tool debuff config in multiplayer.
- Fix an edge case with the Slider's movement math breaking down at high health numbers.
- Fix Shield of Repulsion deflection not working properly.
- Fix a potential edge case with the Shield of Repulsion overriding other mods cancellation of `ProjectileImpactEvent`.
- Fix the optional Shield of Repulsion tooltip being incorrect.
- Fix compatibility support for the Tips mod.
- Fix some configs being checked earlier in mod-loading than necessary to make crash logs more clear in incompatibility edge cases.

# The Aether - NeoForge - 1.21.1-1.5.1-beta.3

Fixes

- Fix eternal day not functioning correctly.
- Fix Silver Dungeons sometimes not generating with aerclouds.
- Fix an incorrect tooltip for Gravitite Armor.
- Fix first-person Shield of Repulsion rendering for players without slim arms.
- Fix projectiles getting stuck on top of the Slider.
- Fix glove modifiers being hardcoded to a specific slot.
- Fix cape textures not being correctly separated per-player.
- Fix Moa Skins not registering on the client.
- Fix incorrect enchantment selection for Valkyrie Lance.

# The Aether - NeoForge - 1.21.1-1.5.1-beta.2

Fixes

- Fix a null crash from the helper for moving accessories from Curios to the new system.
- Fix a null crash from Moa Skin loading.
- Fix Zephyr Snowballs having incorrect shooting trajectory.
- Fix the Sentry's hitbox being larger than it should be.
- Fix Valkyrie Queens not unlocking the full Silver Dungeon when defeated.
- Fix first-person glove rendering for players without slim arms.
- Fix incorrect lengths for some discs in their `jukebox_song` files.
- Fix missing mod logo images.

# The Aether - NeoForge - 1.21.1-1.5.1-beta.1

- Port 1.20.4-1.5.1 to 1.21.1.
