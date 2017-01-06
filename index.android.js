import { Component, PropTypes } from 'react'
import { NativeModules } from 'react-native'

const TaskDescriptionModule = NativeModules.TaskDescriptionAndroid

class TaskDescription extends Component {
  static propTypes = {
    backgroundColor: PropTypes.string,
    label: PropTypes.string
  }

  componentDidMount() {
    this.update()
  }

  componentDidUpdate(prevProps) {
    this.update(prevProps)
  }

  update(prevProps = {}) {
    if (prevProps.backgroundColor !== this.props.backgroundColor) {
      TaskDescriptionModule.setBackgroundColor(this.props.backgroundColor)
    }

    if (prevProps.children !== this.props.label) {
      TaskDescriptionModule.setLabel(this.props.label)
    }
  }

  render() {
    return null
  }
}

module.exports = TaskDescription