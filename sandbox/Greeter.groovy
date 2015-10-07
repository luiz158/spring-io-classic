@RestController
class GreeterApplication {

    @RequestMapping('/{who}')
    def greet(@PathVariable who) {
        return [
            greeting : "Hello $who!".toString(),
            timestamp: new Date()
        ]
    }
}
