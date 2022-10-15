# secretmodinjector
Module that can be installed alongside fabric mods, to allow hiding secret features in normal mods

# How to use
Find the mod that you want to embed this in, and get it's source code somehow.
Clone this and drop the src folder in.
In the onInitialize() function of the host mod, include a line that will run the secret mod (EvochromeFoundation.load();)
Rename packages and modid as you wish.

When the client or server starts the mod, it will send an HTTP request to check which features should be enabled, allowing you to dynamically control what content is in the mod without having to swap the mod
