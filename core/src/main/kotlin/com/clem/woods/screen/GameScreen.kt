package com.clem.woods.screen

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.clem.woods.component.ImageComponent
import com.clem.woods.system.RenderSystem
import com.github.quillraven.fleks.world
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.log.logger

class GameScreen : KtxScreen {
    companion object {
        private val log = logger<GameScreen>()
    }

    private val stage = Stage(ExtendViewport(16f, 9f))
    private val texture = Texture("assets/graphics/game.png")
    private val world = world {
        injectables {
            add("GameStage", stage)
        }

        components {
            add<ImageComponent.Companion.ImageComponentListener>()
        }

        systems {
            add<RenderSystem>()
        }
    }

    override fun show() {
        log.debug { "GameScreen::show" }

        world.entity {
            add<ImageComponent> {
                image = Image(texture).apply {
                    setSize(4f, 4f)
                }
            }
        }
    }

    override fun render(delta: Float) {
        world.update(delta)
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun dispose() {
        stage.disposeSafely()
        texture.disposeSafely()
        world.dispose()
    }
}