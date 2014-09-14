/*
 * This file is part of Flow Components, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 Flow Components <http://flowpowered.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.flowpowered.components;

import java.util.Optional;

/**
 * Represents an object that manages {@link Component} relationships with other objects.
 *
 * It also executes {@link ComponentSystem}s which tract objects with certain components for processing
 */
public interface ComponentManager<H> {
    /**
     * Adds a {@link ComponentSystem} to this manager. The system's class will be used for registration.
     * <p>
     * If the instance's class is already registered, this will override it.
     *
     * @param instance The system
     * @return The system
     */
    <S extends ComponentSystem<H>> S addSystem(S instance);

    /**
     * Adds a {@link ComponentSystem} to this manager keyed to the class.
     *
     * @param instance The system
     * @param clazz The class the instance will be registered to
     * @return The system
     */
    <S extends ComponentSystem<H>> S addSystem(S instance, Class<? super S> clazz);

    /**
     * Gets a {@link ComponentSystem} registered to the class.
     *
     * @param clazz The class to look for an instance registration
     * @return An optional containing the result
     */
    <S extends ComponentSystem<H>> Optional<S> getSystem(Class<S> clazz);

    /**
     * Removes a {@link ComponentSystem} registered to the class.
     *
     * @param clazz The class to look for an instance registration
     * @return An optional containing the result
     */
    <S extends ComponentSystem<H>> Optional<S> removeSystem(Class<S> clazz);

    /**
     * Adds a {@link Component} for the holder. The component's class will be used for registration.
     * <p>
     * If the instance's class is already registered, this will override it.
     *
     * @param holder The holder
     * @param instance The component
     */
    <C extends Component> C addComponent(H holder, C instance);

    /**
     * Adds a {@link Component} for the holder keyed to the class.
     * <p>
     * If the instance's class is already registered, this will override it.
     *
     * @param holder The holder
     * @param instance The component
     * @param clazz The class the instance will be registered to
     * @return The component
     */
    <C extends Component> C addComponent(H holder, C instance, Class<? super C> clazz);

    /**
     * Gets a {@link Component} for the holder registered to the class.
     *
     * @param holder The holder
     * @param clazz The class to look for an instance registration
     * @return An optional containing the result
     */
    <C extends Component> Optional<C> getComponent(H holder, Class<C> clazz);

    /**
     * Returns if the holder has a {@link Component} registration for the class.
     *
     * @param clazz The class to lookup
     * @return True if there is a registration found, false if not
     */
    boolean hasComponent(H holder, Class<? extends Component> clazz);

    /**
     * Removes a {@link Component} for the holder registered to the class.
     *
     * @param holder The holder
     * @param clazz The class to look for an instance registration
     * @return An optional containing the result
     */
    <C extends Component> Optional<C> removeComponent(H holder, Class<C> clazz);
}
