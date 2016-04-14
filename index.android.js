import React, { Component, PropTypes, requireNativeComponent, Text, View } from 'react-native'

const TaskDescriptionAndroid = requireNativeComponent('TaskDescriptionAndroid', TaskDescription)

class TaskDescription extends Component {
  static propTypes = Object.assign({}, View.propTypes, {
    backgroundColor: PropTypes.string,
    children: PropTypes.instanceOf(Text)
  })

  render() {
    const { backgroundColor, children } = this.props

    const label = children ? children.props.children : null

    return (
      <TaskDescriptionAndroid
        backgroundColor={backgroundColor}
        label={label}
      />
    )
  }
}

module.exports = TaskDescription
