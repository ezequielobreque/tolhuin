package tolhuin

class MainController {

    def index() {
    	respond Emprendimiento.list()
	}
}
