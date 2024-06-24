/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans;

/**
 * Interface for strategies that register custom
 * {@link java.beans.PropertyEditor property editors} with a
 * {@link org.springframework.beans.PropertyEditorRegistry property editor registry}.
 * <p>
 * 此接口用于策略，这些策略向属性编辑器注册表注册自定义属性编辑器。
 * 这在需要在多种情况下使用相同属性编辑器集时特别有用：编写相应的注册器并在每种情况下重复使用它。<p/>
 *
 * <p>This is particularly useful when you need to use the same set of
 * property editors in several situations: write a corresponding
 * registrar and reuse that in each case.
 *
 *<p>
 * PropertyEditorRegistry 和 PropertyEditorRegistrar 在 Spring 框架中扮演不同的角色，它们都涉及到属性编辑器（PropertyEditor）的注册和使用，但它们的工作方式和职责不同。
 * <p>PropertyEditorRegistry
 * <p>PropertyEditorRegistry 是一个接口，它定义了注册和查找属性编辑器的方法。具体来说，它提供了以下方法：
 *
 * <p>registerCustomEditor(Class<?> requiredType, PropertyEditor editor)：用于注册一个特定类型的属性编辑器。
 * <p>registerCustomEditor(Class<?> requiredType, String propertyPath, PropertyEditor editor)：用于注册一个特定类型的属性编辑器，同时指定属性路径。
 * <p>getPropertyEditorForType(Class<?> requiredType)：查找并返回给定类型的属性编辑器。
 * <p>PropertyEditorRegistry 被 BeanWrapper 和 DataBinder 等类实现，这些类负责在 Spring 中绑定属性值和处理属性转换。
 *
 * <p>PropertyEditorRegistrar
 * <p>PropertyEditorRegistrar 是一个接口，它的作用是在运行时动态注册一组属性编辑器到 PropertyEditorRegistry。它只有一个方法：
 *
 * <p>void registerCustomEditors(PropertyEditorRegistry registry)：这个方法接收一个 PropertyEditorRegistry 实例作为参数，并允许注册器向其中注册多个属性编辑器。
 * <p>PropertyEditorRegistrar 可以在多种场景下使用，例如在 Spring MVC 控制器中，或者在 CustomEditorConfigurer 配置类中，后者是一个 Spring 配置类，可以用来注册一组标准的或自定义的属性编辑器。
 *
 * <p>总结
 *<p> PropertyEditorRegistry 是一个用于存储和查找属性编辑器的接口，通常由 Spring 的内部组件实现。
 *<p> PropertyEditorRegistrar 是一个可以被 Spring 使用的接口，用于动态注册属性编辑器到 PropertyEditorRegistry。</p>
 *
 * <p>PropertyEditor就是具体类型转换的作用</p>
 *
 * @author Juergen Hoeller
 * @since 1.2.6
 * @see PropertyEditorRegistry
 * @see java.beans.PropertyEditor
 */
public interface PropertyEditorRegistrar {

	/**
	 * Register custom {@link java.beans.PropertyEditor PropertyEditors} with
	 * the given {@code PropertyEditorRegistry}.
	 * <p>The passed-in registry will usually be a {@link BeanWrapper} or a
	 * {@link org.springframework.validation.DataBinder DataBinder}.
	 * <p>It is expected that implementations will create brand new
	 * {@code PropertyEditors} instances for each invocation of this
	 * method (since {@code PropertyEditors} are not threadsafe).
	 * @param registry the {@code PropertyEditorRegistry} to register the
	 * custom {@code PropertyEditors} with
	 */
	void registerCustomEditors(PropertyEditorRegistry registry);

}
